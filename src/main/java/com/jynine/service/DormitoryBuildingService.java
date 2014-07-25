package com.jynine.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jynine.dao.DormitoryBuildingDao;
import com.jynine.model.DormitoryBuilding;
import com.jynine.model.DormitoryRoom;

/**
 * <p>文件名称 : DormitoryBuildingService.java</p>
 * <p>文件描述 : 无 </p>
 * <p>内容摘要 : 无</p>
 * <p>其他说明 : 无</p>
 * <p>完成日期 : 2014年7月23日 下午3:41:16</p>
 * @author 李文军
 */
@Service("dormitoryBuildingService")
public class DormitoryBuildingService {
	
	private Logger log = LoggerFactory.getLogger(DormitoryBuildingService.class.getName());
	
	@Autowired
	private DormitoryBuildingDao dormitoryBuildingDao;
	
	/**
	 * <p>方法描述 : 保存宿舍楼信息 </p>
	 * <p>其他说明 : 无</p>
	 * <p>完成日期 : 2014年7月23日 下午3:43:47</p>
	 * @author 李文军
	 * @param dormitoryBuilding
	 * @return
	 */
	public boolean save(DormitoryBuilding building){
		boolean flag = false;
		try {
			int dbId = dormitoryBuildingDao.insertSelective(building);
			this.saveRoom(dbId, building.getDbNum(), building.getDbRoomNum());
			flag = true;
		} catch (Exception e) {
			log.error("保存宿舍楼信息",e);
			throw e;
		}
		return flag;
	}
	/**
	 * <p>方法描述 : 保存宿舍房间信息 </p>
	 * <p>其他说明 : 无</p>
	 * <p>完成日期 : 2014年7月23日 下午3:47:01</p>
	 * @author 李文军
	 * @param dbId 宿舍楼ID
	 * @param BuidNum 宿舍楼层数
	 * @param roomNum 每层的房间的房间数
	 * @return
	 */
	private boolean saveRoom(int dbId, int BuidNum, int roomNum) {
		boolean flag = false;
		List<DormitoryRoom> rooms = new ArrayList<DormitoryRoom>();
		try {
			for (int i = 1; i <= BuidNum; i++) {
				for (int j = 1; j <= roomNum; j++) {
					String str = "";
					if (j < 10) {
						str = i + "0" + j;
					} else {
						str = i + "" + j;
					}
					DormitoryRoom room = new DormitoryRoom();
					room.setDbId(dbId);
					room.setDrStatus(1);// 空房
					room.setDrNum(str);
					rooms.add(room);
				}
			}
			dormitoryBuildingDao.insertRooms(null);
			flag = true;
		} catch (Exception e) {
			log.error("保存宿舍房间信息", e);
			throw e;
		}
		return flag;
	}
}
