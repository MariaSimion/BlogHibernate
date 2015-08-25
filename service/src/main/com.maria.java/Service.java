import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by msimion on 8/25/2015.
 */

@Path("/")
public class Service {

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUsers(){
        return "test";
    }

}
