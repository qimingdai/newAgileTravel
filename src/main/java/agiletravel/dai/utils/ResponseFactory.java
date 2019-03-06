package agiletravel.dai.utils;


public class ResponseFactory {


    public static Response okResponse(Object object){
        return new Response(200,object);
    }
}
