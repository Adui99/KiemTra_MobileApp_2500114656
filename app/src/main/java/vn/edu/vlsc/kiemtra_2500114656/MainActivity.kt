package vn.edu.vlsc.kiemtra_2500114656

import android.content.Intent // <--- Đảm bảo đã import Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ thành phần giao diện bằng findViewById (Bắt buộc không dùng ViewBinding)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            // Kiểm tra bỏ trống
            if (email.isEmpty() || password.isEmpty()) {
                tvStatus.setTextColor(android.graphics.Color.parseColor("#F44336"))
                tvStatus.text = "Lỗi: Không được để trống Email hoặc Mật khẩu!"
                return@setOnClickListener
            }

            // Kiểm tra định dạng Email
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                tvStatus.setTextColor(android.graphics.Color.parseColor("#F44336"))
                tvStatus.text = "Lỗi: Định dạng Email không hợp lệ!"
                return@setOnClickListener
            }

            // Kiểm tra độ dài mật khẩu (>= 6 ký tự)
            if (password.length < 6) {
                tvStatus.setTextColor(android.graphics.Color.parseColor("#F44336"))
                tvStatus.text = "Lỗi: Mật khẩu phải có ít nhất 6 ký tự!"
                return@setOnClickListener
            }

            // Dữ liệu hợp lệ -> Chuyển màn hình sang ProfileActivity[cite: 2]
            tvStatus.setTextColor(android.graphics.Color.parseColor("#4CAF50"))
            tvStatus.text = "Đăng nhập hợp lệ"

            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("USER_EMAIL", email) // Truyền email qua Bundle/Intent[cite: 2]
            startActivity(intent)
        }
    }
}