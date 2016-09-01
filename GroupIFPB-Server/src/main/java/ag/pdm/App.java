package ag.pdm;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws Exception{
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, 40000);
        //
        Application app = new Application(){
        		public org.restlet.Restlet createInboundRoot() {
        			Router router = new Router();
        			router.attach("/list", ContactsResource.class);
        			router.attach("/list/size", ContactsSizeResource.class);
        			return router;
        		};
        };
        //
        component.getDefaultHost().attach(app);
        //
        component.start();
    }
}
