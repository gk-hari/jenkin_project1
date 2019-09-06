package com.Youtube.service;

import com.Youtube.dao.YoutubeDao;
import com.Youtube.dao.YoutubeDaoInterface;
import com.Youtube.entity.YoutubeEmployee;

public class YoutubeService implements YoutubeServiceInterface
{
	private YoutubeService()
	{
		
	}

	public static YoutubeServiceInterface createServiceObject() {
		// TODO Auto-generated method stub
		return new YoutubeService();
	}

	@Override
	public int createProfile(YoutubeEmployee ye) {
		YoutubeDaoInterface yd=YoutubeDao.createDaoObject();
		return yd.createProfileDao(ye);
		
	}

}
