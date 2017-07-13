package br.com.danielbgg.router;

import org.apache.camel.main.Main;

/**
 * A Camel Application
 */
public class MainRouter {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
        Main main = new Main();
        main.addRouteBuilder(new RouterRouteBuilder());
        main.run(args);
    }

}

