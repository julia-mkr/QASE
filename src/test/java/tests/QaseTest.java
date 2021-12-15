package tests;

import adapters.BaseAdapter;
import adapters.ProjectsAdapter;
import adapters.SuiteAdapter;
import objects.Project;
import objects.TestSuite;
import org.testng.annotations.Test;

public class QaseTest {

    @Test
    public void getProjectsTest() {
        new BaseAdapter().get("/project");
    }

    @Test
    public void createProjectTest() {
        Project project = Project.builder()
                .code("QAJMDEMO")
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
        new SuiteAdapter().create("QAJMDEMO", testSuite);
    }

    @Test
    public void deleteSuiteTest() {
        new SuiteAdapter().delete("QAJMDEMO", 2);
    }
}
