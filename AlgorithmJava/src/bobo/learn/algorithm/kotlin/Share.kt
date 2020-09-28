package bobo.learn.algorithm.kotlin

import java.util.concurrent.ThreadLocalRandom

class Share

/**
 * 分享会
 */
fun main() {

    //从所有安卓小伙伴中抽取一人
    var arr = ArrayList<String>()
    arr.add("周煦明")
    arr.add("田雨露")
    arr.add("李婧馨")
    arr.add("韩博")
    arr.add("金贤伦")
    arr.add("刘硕菲")
    arr.add("杨乐")
    arr.add("李永斌")
    arr.add("邱圣明")
    arr.add("王乾坤")
    arr.add("张占永")
    arr.add("胡学文")
    arr.add("付树棣")
    var position = ThreadLocalRandom.current().nextInt(0, arr.size)
    println("中奖选手：" + arr[position])

//    /**
//     * 排名不分先后
//     */
//    val bonus = ArrayList<String>()
//    bonus.add("交换券")
//    bonus.add("分享后退一格")
//    bonus.add("肩颈放松券（金藏）")
//    bonus.add("可以向主题池里面添加自己感兴趣的、想要了解的主题")
//    bonus.add("夸奖券（全体小伙伴夸奖一分钟）")
//    position = ThreadLocalRandom.current().nextInt(0, arr.size)
//    println("中奖选手：" + bonus[position])
//
//    /**
//     * 处罚
//     */
//    val punish = ArrayList<String>()
//    punish.add("真心话大冒险（分享人挑选一个人，必须用真心话回答）")
//    punish.add("必须从主题池里随机抽取、或选取分享主题")
//    punish.add("体罚：俯卧撑、蛙跳")
//    punish.add("一个月内再来一次")
//    punish.add("提前券")
//    punish.add("wiki券(主题池里的主题选一个，写一篇wiki)")
//    position = ThreadLocalRandom.current().nextInt(0, arr.size)
//    println("中奖选手：" + punish[position])
}