package cn.alsaces.logindemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends Activity {
    // 调用Actvity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);//关联activity_register.xml
        // 关联用户名、密码、确认密码、邮箱和注册、返回登录按钮
        EditText userName = (EditText) this.findViewById(R.id.UserNameEdit);
        EditText passWord = (EditText) this.findViewById(R.id.PassWordEdit);
        EditText passWordAgain = (EditText) this.findViewById(R.id.PassWordAgainEdit);
        EditText email = (EditText) this.findViewById(R.id.EmailEdit);
        Button signUpButton = (Button) this.findViewById(R.id.SignUpButton);
        Button backLoginButton = (Button) this.findViewById(R.id.BackLoginButton);

        // 注册按钮监听器
        signUpButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String strUserName = userName.getText().toString().trim();
                        String strPassWord = passWord.getText().toString().trim();
                        String strPassWordAgain = passWordAgain.getText().toString().trim();
                        String strPhoneNumber = email.getText().toString().trim();
                        //注册格式粗检
                        if (strUserName.length() > 10) {
                            Toast.makeText(SignUpActivity.this, "用户名长度必须小于10！", Toast.LENGTH_SHORT).show();
                        } else if (strUserName.length() < 4) {
                            Toast.makeText(SignUpActivity.this, "用户名长度必须大于4！", Toast.LENGTH_SHORT).show();
                        } else if (strPassWord.length() > 16) {
                            Toast.makeText(SignUpActivity.this, "密码长度必须小于16！", Toast.LENGTH_SHORT).show();
                        } else if (strPassWord.length() < 6) {
                            Toast.makeText(SignUpActivity.this, "密码长度必须大于6！", Toast.LENGTH_SHORT).show();
                        } else if (!strPassWord.equals(strPassWordAgain)) {
                            Toast.makeText(SignUpActivity.this, "两次密码输入不一致！", Toast.LENGTH_SHORT).show();
                        } else if (!strPhoneNumber.contains("@")) {
                            Toast.makeText(SignUpActivity.this, "邮箱格式不正确！", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignUpActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }
                }
        );
        // 注册按钮监听器
        backLoginButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
        );

    }
}
