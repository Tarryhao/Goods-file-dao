package goodsdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 商品储存数据库操作类
 * @author asus
 *
 */
public class GoodsSaveDAO {
	public void savegoods(ArrayList<Goods> list) throws  SQLException, ClassNotFoundException{
		DBConnecttion dbc=new DBConnecttion();
		Connection conn = dbc.getConnection();
		//创建JDBC对象statement
			String sql="insert into goods(goodsname,price,goodsdate,company) values(?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			for(int i=0;i<list.size();i++){ 
				Goods goods=list.get(i);//从ArrayList中取出对象
				ps.setString(1, goods.getGoodsname());//分别设置？的值
				ps.setDouble(2, goods.getPrice());
				ps.setString(3, goods.getDate());
				ps.setString(4, goods.getCompany());
				ps.executeUpdate();//提交
			}
			conn.close();
			dbc.closeConnection();
			ps.close();
			
	}
}
