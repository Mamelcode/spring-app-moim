package org.edupoll.controller.api;

import org.edupoll.model.dto.moim.AttendanceJoinResponseData;
import org.edupoll.model.dto.moim.AttendanceRequestData;
import org.edupoll.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AttendanceAPIController {
	
	@Autowired
	AttendanceService attendanceService;
	
	@PostMapping("/attendance/join")
	public AttendanceJoinResponseData attendanceJoinHandle(AttendanceRequestData attendanceData) {		
		
		AttendanceJoinResponseData result = 
				attendanceService.createAttendance(attendanceData);
		
		return result;
	}
	
	@GetMapping("/attendance/delete")
	public AttendanceJoinResponseData attendanceDeleteHandle(AttendanceRequestData attendanceRequestData) {
		
		System.out.println("user => "+ attendanceRequestData.getUserId());
		System.out.println("moim => "+ attendanceRequestData.getMoimId());
		
		AttendanceJoinResponseData result = 
				attendanceService.deleteAttendance(attendanceRequestData);
		
		return result;
	}
}
