package edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.tests.accesscontrol;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.kit.ipd.sdq.dataflow.privacy.analysis.prolog.generator.IEcore2TxtGenerator;

public class PrologAccessControlAnalysisTest {

	protected interface SolutionAsserter extends Consumer<Collection<Map<String, Term>>> {
	}

	private IEcore2TxtGenerator generator;
	private File prologFile;

	@Before
	public void setup() throws Exception {
		generator = new PrologGeneratorStandalone().getGenerator();
		prologFile = File.createTempFile("prologTest", ".pl");
		prologFile.deleteOnExit();
	}

	@After
	public void finalize() {
		Query unloadQuery = new Query("unload_file", new Atom(prologFile.getAbsolutePath()));
		if (!unloadQuery.hasSolution()) {
			throw new IllegalStateException(
					"The prolog file could not be unloaded. Following test executions might fail.");
		}
	}

	@Test
	public void testMinimalSuccess() throws IOException {
		assertSuccess("minimalSuccess.xmi");
	}
	
	@Test
	public void testMinimalTransitiveSuccess() throws IOException {
		assertSuccess("minimalTransitiveSuccess.xmi");
	}
	
	@Test
	public void testMinimalTransitiveSuccessExplicitGrant() throws IOException {
		assertSuccess("minimalTransitiveSuccessExplicitGrant.xmi");
	}
	
	@Test
	public void testMinimalTransitiveSuccessSelection() throws IOException {
		assertSuccess("minimalTransitiveSuccessSelection.xmi");
	}

	@Test
	public void testMinimalFailureRoleMismatch() throws IOException {
		assertFailure("minimalFailureRoleMismatch.xmi", "fs_1", "fs_2");
	}
	
	@Test
	public void testMinimalTransitiveFailureRoleMismatch() throws IOException {
		assertFailure("minimalTransitiveFailureRoleMismatch.xmi","fn_1");
	}
	
	@Test
	public void testMinimalTransitiveFailureSelection() throws IOException {
		assertFailure("minimalTransitiveFailureSelection.xmi","fs_2");
	}

	protected void assertSuccess(String modelName) throws IOException {
		assertSolutions(modelName, solutions -> {
			assertTrue("Found solution but should not: " + Optional.ofNullable(solutions.iterator())
					.filter(Iterator::hasNext).map(Iterator::next).map(Object::toString), solutions.isEmpty());
		});
	}

	protected void assertFailure(String modelName) throws IOException {
		assertSolutions(modelName, solutions -> {
			assertFalse(solutions.isEmpty());
		});
	}

	protected void assertSolutions(String modelName, SolutionAsserter asserter) throws IOException {
		initTest(modelName);
		Query q = new Query(Util.textToTerm("illegalAccess(N, D, R)"));
		asserter.accept(Arrays.asList(q.allSolutions()));
	}
	
	protected void assertFailure(String modelName, String... expectedProblematicNodes) throws IOException {
		assertSolutions(modelName, solutions -> {
			assertFalse(solutions.isEmpty());
			Set<String> problematicNodes = solutions.stream()
					.map(PrologAccessControlAnalysisTest::getProblematicNodeName).filter(Objects::nonNull)
					.collect(Collectors.toSet());
			assertEquals(new HashSet<>(Arrays.asList(expectedProblematicNodes)), problematicNodes);
		});
	}

	protected void initTest(String modelFileName) throws IOException {
		ResourceSet rs = new ResourceSetImpl();
		URL modelUrl = getClass().getResource(modelFileName);
		URI modelUri = URI.createURI(modelUrl.toString());
		Resource r = rs.getResource(modelUri, true);
		EcoreUtil.resolveAll(rs);
		String prologCode = generator.generateContentsFromResource(r);
		FileUtils.write(prologFile, prologCode);

		Query loadingQuery = new Query("consult", new Atom(prologFile.getAbsolutePath()));
		assertTrue("Failed to load generated prolog program", loadingQuery.hasSolution());
	}

	protected static String getProblematicNodeName(Map<String, Term> solution) {
		return Optional.ofNullable(solution.get("N")).map(Term::toString).orElse(null);
	}

}
