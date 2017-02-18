package com.pay4later.serialization.marshalling;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created:     by Abdul Al-Faraj
 * Date:        18/02/2017 -- 18:59
 * Class:       com.pay4later.serialization.marshalling.PersonMapperTestSuite
 */
@RunWith(Suite.class)

@Suite.SuiteClasses({
        JsonMapperTest.class,
        XMLMapperTest.class,
        CSVMapperTest.class
})

public class PersonMapperTestSuite {
}
