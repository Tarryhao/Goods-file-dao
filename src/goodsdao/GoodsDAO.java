package goodsdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class GoodsDAO {
	public void savegoods(ArrayList<Goods> list) throws  SQLException, ClassNotFoundException{
		   Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.�õ�����
			// DriverManager.getConnection("����Э��", "�û���", "����");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "Study_user", "123456");
			String sql="insert into goods(goodsname,price,goodsdate,company) values(?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			for(int i=0;i<list.size();i++){ 
				Goods goods=list.get(i);//��ArrayList��ȡ������
				ps.setString(1, goods.getGoodsname());//�ֱ����ã���ֵ
				ps.setDouble(2, goods.getPrice());
				ps.setString(3, goods.getDate());
				ps.setString(4, goods.getCompany());
				ps.executeUpdate();//�ύ
			}
			
	}
}
