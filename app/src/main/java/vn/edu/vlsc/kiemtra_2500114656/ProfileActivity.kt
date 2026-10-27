package vn.edu.vlsc.kiemtra_2500114656

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Ánh xạ View bằng findViewById theo yêu cầu đề bài
        val tvUserEmail = findViewById<TextView>(R.id.tvUserEmail)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        // Nhận dữ liệu Email từ Intent được truyền sang
        val email = intent.getStringExtra("USER_EMAIL")
        tvUserEmail.text = "Email: $email"

        // Xử lý nút Đăng xuất: đóng Activity hiện tại bằng finish() để quay về màn hình Login
        btnLogout.setOnClickListener {
            finish()
        }
    }
}