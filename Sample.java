package baidu;

import com.baidu.aip.face.AipFace;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "9508971";
    public static final String API_KEY = "WLrsB0jw9ELS3wQx9ydNNVgA";
    public static final String SECRET_KEY = "SyKhRNn38XpELjXUxyeYjR1LI1G96Tmc";

    private static AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
    private static final String GROUND_ID = "part4";

    public static void main(String[] args) {
        // 初始化一个AipFace


        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置

        // 调用接口
//        String path = "G:/walker/verification_1.jpeg";
//        JSONObject res = client.detect(path, new HashMap<String, String>());
//        System.out.println(res.toString(2));

//        compare(client);
//        register(client);
//        register2(client);

//        register100();
        searchGroupUsers();
//        search();
//        register100();
        face();
    }

    private static void register_100() {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("action_type", "replace");

        for (int i = 10; i < 100; i++) {
            String uid = "phone_" + i;
            String userInfo = "姓名 : newName---" + i;

            // 参数为本地图片路径
            String image = "G:/walker/face/" + i % 10 + ".jpg";
            JSONObject res = client.addUser(uid, userInfo, GROUND_ID, image, options);
            System.out.println(">>>>>>>>>>>>> 人脸注册 <<<<<<<<<<<<<<<<<<< " + i);
            System.out.println(res.toString(2));
        }
    }

    private static void register100() {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("action_type", "replace");

        for (int i = 10; i < 100; i++) {
            String uid = "json_num_" + i;
            String userInfo = "姓名 : Json---" + i;

            // 参数为本地图片路径
            String image = "G:/walker/timg.jpg";
            JSONObject res = client.addUser(uid, userInfo, GROUND_ID, image, options);
            System.out.println(">>>>>>>>>>>>> 人脸注册 <<<<<<<<<<<<<<<<<<< " + i);
            System.out.println(res.toString(2));
        }
    }

    private static void register() {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("action_type", "replace");

        String uid = "18502076244";
        String userInfo = "姓名 : Walker";

        // 参数为本地图片路径
        String image = "G:/walker/timg.jpg";
        JSONObject res = client.addUser(uid, userInfo, GROUND_ID, image, options);
        System.out.println(">>>>>>>>>>>>> 人脸注册 <<<<<<<<<<<<<<<<<<<");
        System.out.println(res.toString(2));
    }
    private static void registerMichael() {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("action_type", "replace");

        String uid = "17502076255";
        String userInfo = "姓名 : Michael";

        // 参数为本地图片路径
        String image = "G:/walker/verification_1.jpeg";
        JSONObject res = client.addUser(uid, userInfo, GROUND_ID, image, options);
        System.out.println(">>>>>>>>>>>>> 人脸注册-Michael <<<<<<<<<<<<<<<<<<<");
        System.out.println(res.toString(2));
    }

    private static void registerZhou() {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("action_type", "replace");

        String uid = "15555076255";
        String userInfo = "姓名 : 周杰伦";

        // 参数为本地图片路径
        String image = "G:/walker/zhou_1.jpg";
        JSONObject res = client.addUser(uid, userInfo, GROUND_ID, image, options);
        System.out.println(">>>>>>>>>>>>> 人脸注册-周杰伦 <<<<<<<<<<<<<<<<<<<");
        System.out.println(res.toString(2));
    }

    private static void registerXiaoBing() {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("action_type", "replace");

        String uid = "1444076255";
        String userInfo = "姓名 : 小兵";

        // 参数为本地图片路径
        String image = "G:/walker/shaBing_1.jpg";
        JSONObject res = client.addUser(uid, userInfo, GROUND_ID, image, options);
        System.out.println(">>>>>>>>>>>>> 人脸注册-小兵 <<<<<<<<<<<<<<<<<<<");
        System.out.println(res.toString(2));
    }

    private static void search () {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("start", "0");
        options.put("end", "200");

        // 组列表查询
        JSONObject res = client.getGroupList(options);
        System.out.println(">>>>>>>>>>>>> 组列表查询 <<<<<<<<<<<<<<<<<<<");
        System.out.println(res.toString(2));
    }


    private static void searchGroupUsers() {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("start", "0");
        options.put("end", "1000");

        // 组内用户列表查询
        JSONObject res = client.getGroupUsers(GROUND_ID, options);
        System.out.println(">>>>>>>>>>>>> 组内用户列表查询 <<<<<<<<<<<<<<<<<<<");
        System.out.println(res.toString(2));
    }

    private static void delete () {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();

        String groupId = "5_floor,6_floor";
        String uid = "Michael_Jackson";

        // 组内删除用户
        JSONObject res = client.deleteGroupUser(groupId, uid, options);
        System.out.println(">>>>>>>>>>>>> 组内删除用户 <<<<<<<<<<<<<<<<<<<");
        System.out.println(res.toString(2));
    }

    private static void face() {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("ext_fields", "faceliveness");
        options.put("user_top_num", "3");


        // 参数为本地图片路径
        String image = "G:/walker/face/1.jpg";
        System.out.println("Begin ... >>>>>>>>>>>>> 人脸识别 <<<<<<<<<<<<<<<<<<< " + Calendar.getInstance().get(Calendar.SECOND));
        JSONObject res = client.identifyUser(GROUND_ID, image, options);
        System.out.println("End ...   >>>>>>>>>>>>> 人脸识别 <<<<<<<<<<<<<<<<<<< " + Calendar.getInstance().get(Calendar.SECOND));
        System.out.println(res.toString(2));
    }

}
