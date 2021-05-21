package com.zzh.exercise;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.request.OapiUserGetRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.dingtalk.api.response.OapiUserGetResponse;
import com.taobao.api.ApiException;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @Author: Zhenghan
 * @Description:
 * @Date: Create by 2020/11/27
 */
public class DingDingRebot {
    //https://oapi.dingtalk.com/robot/send?access_token=05d8edcb1ef8175830d949fb5b4539c44c62f817114e1d95b518943118861591
    private static final String accessToken = "05d8edcb1ef8175830d949fb5b4539c44c62f817114e1d95b518943118861591";
    private static String[] name = new String[6];
    private static String[] doWhat = new String[10];
    private static String[] whereDo = new String[10];
    static {
        name[0] = "郑晗";
        name[1] = "冯玉珍";
        name[2] = "陈恩远";
        name[3] = "张心妍";
        name[4] = "张梦菲";
        name[5] = "盛彦丽";

        doWhat[0] = "化妆";
        doWhat[1] = "吃饭";
        doWhat[2] = "爬树";
        doWhat[3] = "上山";
        doWhat[4] = "游泳";
        doWhat[5] = "做饭";
        doWhat[6] = "写bug";
        doWhat[7] = "抽风";
        doWhat[8] = "长痘";
        doWhat[9] = "傻笑";


        whereDo[1] = "家里";
        whereDo[2] = "公司";
        whereDo[3] = "学校";
        whereDo[4] = "雪山";
        whereDo[5] = "树上";
        whereDo[6] = "厕所";
        whereDo[7] = "公交车上";
        whereDo[8] = "桌子上";
        whereDo[9] = "被子里";
        whereDo[0] = "水里";


    }

    public static void main(String[] args) throws ApiException {
        for (int i = 0; i < 1; i++) {
            sendMessage();
        }
    }


    public void test() throws ApiException {

        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/get");
        OapiUserGetRequest req = new OapiUserGetRequest();
        req.setUserid("userid1");
        req.setHttpMethod("GET");
        OapiUserGetResponse rsp = client.execute(req, accessToken);

    }

    public static  void sendMessage() throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=05d8edcb1ef8175830d949fb5b4539c44c62f817114e1d95b518943118861591");
        OapiRobotSendRequest request = new OapiRobotSendRequest();
       /* request.setMsgtype("text");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent("测试文本消息");
        request.setText(text);
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        at.setAtMobiles(Arrays.asList("132xxxxxxxx"));
// isAtAll类型如果不为Boolean，请升级至最新SDK
        at.setIsAtAll(true);
        request.setAt(at);*/
        int random = (int) ( Math.random () * 5 );
        int w = (int) ( Math.random () * 10 );
        request.setMsgtype("markdown");
        OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
        markdown.setTitle("猜猜你在做什么？");
        //https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=871029732,1516512573&fm=26&gp=0.jpg
        //www.weather.com.cn
        //https://amazinghan.gitee.io/
        markdown.setText("#### "+"@"+name[random]+" 在" + whereDo[w] + doWhat[w] +"\n" );
                //"> 今天天气真好啊\n\n" );
                //"> ![screenshot](http://tiebapic.baidu.com/forum/w%3D580%3B/sign=da501b6dc51b0ef46ce89856edff50da/aec379310a55b3199556d13654a98226cefc17c1.jpg)\n"  +
               // "> ###### "+ LocalDateTime.now() +" [点击我看详情啊 >_< ! ](http://www.weather.com.cn/weather/101210101.shtml) \n");

        request.setMarkdown(markdown);
        System.out.println(markdown.getText());
        OapiRobotSendResponse response = client.execute(request);
        System.out.println(response.getMessage());
        System.out.println(response.getErrcode()+"----"+response.getErrmsg());
    }


}
