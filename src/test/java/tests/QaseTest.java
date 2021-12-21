package tests;

import adapters.BaseAdapter;
import adapters.ProjectsAdapter;
import adapters.SuiteAdapter;
import objects.Project;
import objects.TestSuite;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QaseTest {

    private static final String PROJECT_CODE = "QAJMDEMO";
    SuiteAdapter suiteAdapter = new SuiteAdapter();

    @Test
    public void getProjectsTest() {
        new BaseAdapter().get("/project");
    }

    @Test
    public void createProjectTest() {
        Project project = Project.builder()
                .code(PROJECT_CODE)
                .title("QA08JMDEMOTITLE")
                .description("Test project")
                .build();
        new ProjectsAdapter().create(project);
    }

    @Test
    public void createSuiteTest() {
        TestSuite testSuite = TestSuite.builder()
                .title("Regression test")
                .description("This is a regression test suite")
                .preconditions("These are preconditions")
                .build();
        suiteAdapter.create(PROJECT_CODE, testSuite);
        Assert.assertEquals(testSuite.getTitle(), "Regression test");
    }

    @Test
    public void deleteSuiteTest() {
        TestSuite testSuite = TestSuite.builder()
                .title("Smoke tests")
                .description("The suite contains of smoke tests")
                .build();
        int id = suiteAdapter.create(PROJECT_CODE, testSuite);
        suiteAdapter.delete(PROJECT_CODE, id);
        Assert.assertFalse(suiteAdapter.getSuiteCase(PROJECT_CODE, id));
    }
}
