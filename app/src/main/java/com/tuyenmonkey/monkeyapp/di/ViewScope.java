package com.tuyenmonkey.monkeyapp.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

/**
 * Created by Tuyen Monkey on 2/19/17.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewScope {
}
