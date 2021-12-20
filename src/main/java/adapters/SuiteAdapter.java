package adapters;

import objects.TestSuite;

public class SuiteAdapter extends BaseAdapter {

    public static final String SUITE_URI = "/suite/%s";
    public static final String GET_AND_DELETE_SUITE_URI = SUITE_URI + "/%d";

    public int create(String projectCode, TestSuite testSuite) {
        return post(String.format(SUITE_URI, projectCode), converter.toJson(testSuite))
                .body().path("result.id");
    }

    public void delete(String projectCode, int id) {
        delete(String.format(GET_AND_DELETE_SUITE_URI, projectCode, id));
    }

    public boolean getSuiteCase(String projectCode, int id) {
        return get(String.format(GET_AND_DELETE_SUITE_URI, projectCode, id))
                .body().path("status");
    }
}
