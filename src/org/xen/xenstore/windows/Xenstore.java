/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xen.xenstore.windows;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 *
 * @author win7
 */
public class Xenstore {

    public static void main(String[] args) {
//        JacobLibrary.init();
        ActiveXComponent wmi = null;
        wmi = new ActiveXComponent("winmgmts:\\\\.\\root\\wmi");
        Dispatch base = wmi.invoke("InstancesOf", "CitrixXenStoreBase").toDispatch();
        System.out.println(Dispatch.get(base, "Count"));
        Dispatch.get
    }
}
