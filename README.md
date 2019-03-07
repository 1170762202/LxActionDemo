# LxActionDemo
* 在平时的项目开发过程中，会碰到这样的需求：在执行某个目标行为时，要通过前置的种种校验。
* for example:要进入到某个界面或者执行某项功能时，要进行用户是否登录进行判断，如果登录则进入目标界面，反之，则进入登录界面，登录成功后进入到目标界面
* 看文字很抽象？新建个流程撸出来看看

    ![action.png](https://upload-images.jianshu.io/upload_images/4906229-50ad85456cc7aa8b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


基本执行流程：
![ac.png](https://upload-images.jianshu.io/upload_images/4906229-e7f2bb9f55ed789f.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


看下效果：
![123.gif](https://upload-images.jianshu.io/upload_images/4906229-03aaad601263e448.gif?imageMogr2/auto-orient/strip)


[博客传送门](https://www.jianshu.com/p/f881515f4bda)


## Step 1.Add it in your root build.gradle at the end of repositories:


```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
## Step 2. Add the dependency

```
dependencies {
	        implementation 'com.github.1170762202:LxCheckAction:1.0.1'
	}
```

### 在需要地方进行如下校验
```
 LxAction.getInstance()
                .addAction(new Action() {
                    @Override
                    public void doAction() {//校验成功跳转到订单详情界面
                        startActivity(new Intent(MainActivity.this, OrderActivity.class));
                    }
                })
                .addValid(new LoginValid(this))//登录校验
                .doCheck();
```
### 登录校验器
```
public class LoginValid implements Valid {
    private Context context;

    public LoginValid(Context context) {
        this.context = context;
    }

    @Override
    public boolean check() {
    //自行校验，判断用户本地
        return MainActivity.isLogin;
    }

    @Override
    public void doValid() {
    //进入登录界面
        context.startActivity(new Intent(context, LoginActivity.class));
    }
}
```
### 登录了界面
```public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
        MainActivity.isLogin = true;
        //注意登录成功后执行doAction，继续校验
        LxAction.getInstance().doCheck();
        finish();
    }
}
```
