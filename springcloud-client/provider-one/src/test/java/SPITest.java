import com.springcloud.client.common.api.PostMessage;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class SPITest {

    @Test
    public void test(){
        ExtensionLoader<PostMessage> postMessageExtensionLoader=ExtensionLoader.getExtensionLoader(PostMessage.class);
        PostMessage postMessage=postMessageExtensionLoader.getExtension("main");
        postMessage.sendMsg("hello");
    }

    @Test
    public void test1(){
        ExtensionLoader<PostMessage> postMessageExtensionLoader=ExtensionLoader.getExtensionLoader(PostMessage.class);
        PostMessage postMessage=postMessageExtensionLoader.getAdaptiveExtension();
//        postMessage.sendMsg("sd");
        Map<String, String> parameters =new HashMap<>();
        parameters.put("post.message","main");
        URL url=new URL("dubbo","localhost",8080,parameters);

        postMessage.sendMsg(url,"hello");
    }

    @Test
    public void test2(){
        String url="/Users/top1ms/Java/";
        File file=new File(url);

    }
}
