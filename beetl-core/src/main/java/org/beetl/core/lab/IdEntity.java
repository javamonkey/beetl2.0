package org.beetl.core.lab;

import java.io.Serializable;

public interface IdEntity<ID extends Serializable> extends Serializable {

public abstract void setId(ID id);

public abstract ID getId();

}