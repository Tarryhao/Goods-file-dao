package goodsdao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 商品输出操作类
 * @author asus
 *
 */
public class GoodsPutDAO {
	public ArrayList<Goods> putgoods() throws ClassNotFoundException, SQLException{
		ArrayList<Goods> list=new ArrayList<Goods>();
		DBConnecttion dbc=new DBConnecttion();
		Connection conn = dbc.getConnection();
		//创建JDBC对象statement
		Statement statement = conn.createStatement();
		String sql="select * from goods";
		ResultSet exe = statement.executeQuery(sql);
		while (exe.next()) {	
			//把从数据库取出的信息存入对象里
			
			Goods goods=new Goods();//先把取出的值传入对象中
			goods.setGoodsname(exe.getString("GOODSNAME"));
			goods.setPrice(exe.getDouble("PRICE"));
			goods.setDate(exe.getString("GOODSDATE"));
			goods.setCompany(exe.getString("COMPANY"));
			list.add(goods);//把对象加入ArrayList中
			
		}
		conn.close();
		statement.close();
		dbc.closeConnection();
		return list;
		
	}

}
