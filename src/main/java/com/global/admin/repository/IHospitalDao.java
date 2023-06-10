package com.global.admin.repository;
import java.util.List;
import com.global.entity.DoctorDetails;
import com.global.entity.StaffDeatils;



	public interface IHospitalDao {

			//list DoctorDetails
			public List<DoctorDetails> getDoctor();
			
			//List staffDetails
			public List<StaffDeatils > getStaff();
			
			//insert /update insert doctor
			public void saveDoctorDetails(DoctorDetails theDoctor);
			
			//update DoctorDetails
			public DoctorDetails getDoctorupdate(int theId);
			
			//insert staff details
			public void saveStaffDeatils(StaffDeatils theStaff);
			
			//update StaffDetails
			public StaffDeatils getStaffupdate(int theId);
			
			
			//Search by doctorId
			public DoctorDetails searchById(int id);
			
			//disable doctor
			public void disableDoc(DoctorDetails thedoc);
			
			//disable staffDetails
			public void disableSta(StaffDeatils thesta);
			
			//Search by StaffId
			public StaffDeatils searchByIds(int id);
			
			//delete doctorDetails
			public void deleteDoctor (DoctorDetails theDoctor);
			
			//delete StaffDetails
			public void deleteStaff (StaffDeatils theStaff);
			
			//Search by DoctorName
			public List<DoctorDetails> searchByName(String Name);
			
			//Search by StaffName
			public List<StaffDeatils> searchByNames(String Name);
			
	
		    	
			
			
			
	}



