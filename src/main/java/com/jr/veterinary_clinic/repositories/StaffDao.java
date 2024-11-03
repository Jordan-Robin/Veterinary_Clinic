package com.jr.veterinary_clinic.repositories;

import com.jr.veterinary_clinic.models.Staff;

public interface StaffDao {

    public Staff getStaffByMail(String mail);

}

