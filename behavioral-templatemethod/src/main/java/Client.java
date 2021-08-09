public class Client {
    public static void main(String[] args) {
        Request req = new Request("GET");
        SiteAServlet servlet = new SiteAServlet();
        servlet.service(req);
    }
}

// 模仿HttpRequest
class Request {
    String method;

    public Request(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}

// 模仿 HTTPServlet
abstract class AbstractServlet {
    // 不希望覆盖此方法
    final void service(Request req) {
        httpRepare();
        if ("GET".equals(req.getMethod())) {
            doGet(req);
        } else if ("POST".equals(req.getMethod())) {
            doPost(req);
        } else if ("PUT".equals(req.getMethod())) {
            doPut(req);
        } else {
            System.out.println("wrong http method: " + req.getMethod());
        }
    }

    ;

    void httpRepare() {
        System.out.println("HTTP准备工作");
    }

    abstract void doGet(Request req);

    abstract void doPost(Request req);

    abstract void doPut(Request req);
}

class SiteAServlet extends AbstractServlet {

    @Override
    void doGet(Request req) {
        System.out.println("A get");
    }

    @Override
    void doPost(Request req) {
        System.out.println("A post");
    }

    @Override
    void doPut(Request req) {
        System.out.println("A put");
    }
}


class SiteBServlet extends AbstractServlet {

    @Override
    void doGet(Request req) {
        System.out.println("B get");
    }

    @Override
    void doPost(Request req) {
        System.out.println("B post");
    }

    @Override
    void doPut(Request req) {
        System.out.println("B put");
    }
}