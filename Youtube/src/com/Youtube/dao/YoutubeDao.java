package com.Youtube.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.Youtube.entity.YoutubeEmployee;

public class YoutubeDao implements YoutubeDaoInterface
{
private YoutubeDao()
{
	
}
	
	public static YoutubeDaoInterface createDaoObject() {
		// TODO Auto-generated method stub
		return new YoutubeDao();
	}

	@Override
	public int createProfileDao(YoutubeEmployee ye) {
		int i=0;
		try
		{
		InitialContext ctx =new InitialContext();
		DataSource ds;
		ds=(DataSource)ctx.lookup("java:/zensar");
		
		Connection con=ds.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into Youtube values(?,?,?,?)");
		ps.setString(1, ye.getName());
		ps.setString(2, ye.getPassword());
		ps.setString(3,ye.getEmail() );
		ps.setString(4, ye.getAddress());
		i=ps.executeUpdate();
		
		
	
	} catch(Exception e)
		{
		e.printStackTrace();
		}
		return i;
	}

}
