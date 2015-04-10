package goodsdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * ��Ʒ�������ݿ������
 * @author asus
 *
 */
public class GoodsSaveDAO {
	public void savegoods(ArrayList<Goods> list) throws  SQLException, ClassNotFoundException{
		DBConnecttion dbc=new DBConnecttion();
		Connection conn = dbc.getConnection();
		//����JDBC����statement
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
			conn.close();
			dbc.closeConnection();
			ps.close();
			
	}
}
