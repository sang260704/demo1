/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.dao;

import com.edusys.utils.XJdbc;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Sangnvpc06179
 */
public class ThongKeDAO {

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getBangDiem(Integer maKH) {
        String sql = "{CALL sp_BangDiem(?)}";
        String[] cols = {"MaNguoiHoc", "HoTen", "Diem"};
        return this.getListOfArray(sql, cols, maKH);
    }

    public List<Object[]> getLuongNguoiHoc() {
        String sql = "{CALL sp_LuongNguoiHoc}";
        String[] cols = {"NAM", "SOLUONG", "SOMNHAT", "TRENHAT"};
        return this.getListOfArray(sql, cols);
    }

    public List<Object[]> getDiemChuyenDe() {
        String sql = "{CALL sp_DiemChuyenDe}";
        String[] cols = {"TENCD", "SOLUONGHV", "DIEMNHONHAT", "DIEMLONNHAT", "DIEMTB"};
        return this.getListOfArray(sql, cols);
    }

    public List<Object[]> getDoanhThu(int nam) {
        String sql = "{CALL sp_DoanhThu(?)}";
        String[] cols = {"TENCD", "SOKHOA", "SOHV", "DOANHTHU", "THAPNHAT", "CAONHAT", "TRUNGBINH"};
        return this.getListOfArray(sql, cols, nam);
    }
}
