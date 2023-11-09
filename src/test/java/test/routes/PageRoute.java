package test.routes;

public class PageRoute {
    private String baseURL;

    public PageRoute(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getDashboardPageURL() {
        return baseURL + "/dashboard";
    }

    public String getProductPageURL() {
        return baseURL + "/products";
    }

    public String getCreateProductPageURL() {
        return getProductPageURL() + "/create";
    }
}
