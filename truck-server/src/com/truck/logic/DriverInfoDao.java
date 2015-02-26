package com.truck.logic;

import java.util.List;

import com.truck.domain.DriverInfo;
import com.truck.util.AboutPage;

public interface DriverInfoDao {

	public boolean addDriverInfo(DriverInfo driverInfo);

	public DriverInfo getDriverInfoById(String phone);

	public List<DriverInfo> showDriverInfos(int offset, AboutPage aboutPage,
			List<DriverInfo> driverInfos, int pageSize);

	public boolean updateDriverInfo(DriverInfo driverInfo);

	public boolean deleteDriverInfo(String phone);
}
