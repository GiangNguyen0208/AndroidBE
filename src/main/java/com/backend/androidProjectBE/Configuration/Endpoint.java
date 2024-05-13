package com.backend.androidProjectBE.Configuration;

public class Endpoint {
        public static final String front_end_host = "http://localhost:8080";
        public static final String[] PUBLIC_GET_ENDPOINS = { "/sach", "/sach/**", "/hinh-anh", "/hinh-anh/**",
                "/nguoi-dung/search/existsByTenDangNhap", "/nguoi-dung/search/existsByEmail", "/tai-khoan/kich-hoat" };

        public static final String[] PUBLIC_POST_ENDPOINS = { "/tai-khoan/dang-ky", "/tai-khoan/dang-nhap", };

        public static final String[] ADMIN_GET_ENDPOINS = { "/nguoi-dung", "/nguoi-dung/**", "/hello/**" };
        public static final String[] ADMIN_POST_ENDPOINS = { "/sach", };
}
