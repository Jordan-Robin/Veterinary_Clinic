package fr.eni.veterinary_clinic.repository;

import fr.eni.veterinary_clinic.model.Staff;

public interface StaffDAO {

    public Staff getStaffByMail(String mail);

}
