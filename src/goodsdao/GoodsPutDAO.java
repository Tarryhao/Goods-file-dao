package goodsdao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * ��Ʒ���������
 * @author asus
 *
 */
public class GoodsPutDAO {
	public ArrayList<Goods> putgoods() throws ClassNotFoundException, SQLException{
		ArrayList<Goods> list=new ArrayList<Goods>();
		DBConnecttion dbc=new DBConnecttion();
		Connection conn = dbc.getConnection();
		//����JDBC����statement
		Statement statement = conn.createStatement();
		String sql="select * from goods";
		ResultSet exe = statement.executeQuery(sql);
		while (exe.next()) {	
			//�Ѵ����ݿ�ȡ������Ϣ���������
			
			Goods goods=new Goods();//�Ȱ�ȡ����ֵ���������
			goods.setGoodsname(exe.getString("GOODSNAME"));
			goods.setPrice(exe.getDouble("PRICE"));
			goods.setDate(exe.getString("GOODSDATE"));
			goods.setCompany(exe.getString("COMPANY"));
			list.add(goods);//�Ѷ������ArrayList��
			
		}
		conn.close();
		statement.close();
		dbc.closeConnection();
		return list;
		
	}

}
