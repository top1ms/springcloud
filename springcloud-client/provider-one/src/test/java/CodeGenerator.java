import org.apache.dubbo.common.extension.ExtensionLoader;

public class CodeGenerator {

public class PostMessage$Adaptive implements com.springcloud.client.common.api.PostMessage {
    public void sendMsg(java.lang.String arg0) {
        throw new UnsupportedOperationException("The method public abstract void com.springcloud.client.common.api.PostMessage.sendMsg(java.lang.String) of interface com.springcloud.client.common.api.PostMessage is not adaptive method!");
    }

    public void sendMsg(org.apache.dubbo.common.URL arg0, java.lang.String arg1) {
        if (arg0 == null) throw new IllegalArgumentException("url == null");
        org.apache.dubbo.common.URL url = arg0;
        String extName = url.getParameter("post.message", "main");
        if (extName == null)
            throw new IllegalStateException("Failed to get extension (com.springcloud.client.common.api.PostMessage) name from url (" + url.toString() + ") use keys([post.message])");
        com.springcloud.client.common.api.PostMessage extension = (com.springcloud.client.common.api.PostMessage) ExtensionLoader.getExtensionLoader(com.springcloud.client.common.api.PostMessage.class).getExtension(extName);
        extension.sendMsg(arg0, arg1);
    }
}
}