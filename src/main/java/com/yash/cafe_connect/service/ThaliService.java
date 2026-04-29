package com.yash.cafe_connect.service;

import com.yash.cafe_connect.entity.Thali;
import java.util.List;

public interface ThaliService {

    Thali createThali(Thali thali);

    List<Thali> getAllThali();
}