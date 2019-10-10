package com.service;

import com.entity.Admin;

public interface AdminService {
   Boolean authentication(Admin admin);
   Boolean addAdmin(Admin admin);

}
