package com.actors.example

import org.scalatest.funsuite.AnyFunSuite

//class DeviceTest extends AnyFunSuite {
//  "reply with empty reading if no temperature is known" in {
//
//    val probe = TestProbe()
//    val deviceActor = system.actorOf(Device.props("group", "device"))
//
//    deviceActor.tell(Device.ReadTemperature(requestId = 42), probe.ref)
//    val response = probe.expectMsgType[Device.RespondTemperature]
//    response.requestId should ===(42L)
//    response.value should ===(None)
//  }
//}
