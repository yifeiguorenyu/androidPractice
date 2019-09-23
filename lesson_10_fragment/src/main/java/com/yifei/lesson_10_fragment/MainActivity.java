package com.yifei.lesson_10_fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    ArrayAdapter adapter;
    String[] titles = {"习近平回信寄语全国涉农高校师生 全文",
            "掌握斗争规律 讲求斗争方法  百年大党召唤伟大斗争",
            " 将道德榜样化为奋进新时代的无穷动力 《追梦人》",
            "中国稳健前行|中国特色社会主义民主的特点和优势",
            "做到了，而且比我们想象的更好 心连心 爱香港",
            " 人民日报任理轩:狂风骤雨不能掀翻大海  新华时评"};

    String[] contents = {
            "今天，实现我们党确定的目标任务，光有勇气是不够的，" +
                    "盲打莽撞是不可能取得胜利的。善于把握规律，是我们党领导推动工作的制胜法宝，" +
                    "也是我们提高斗争本领的重要途径。这就要求我们在各种重大斗争中，坚持增强忧患意识和保持战略定力相统一、坚持战略判断和战术决断相统一、坚持斗争过程和斗争实效相统一。“善战者，求之于势。”对大局和大势的准确把握，历来是我们赢得斗争的先决条件。对领导干部来说，要谋子之前先谋势、" +
                    "着眼全局看局部，同时决断和行动要又快又准，精准把握斗争进程、判断出招时机，找准靶心、一击即中。",
            "斗争是有章法的，不是逞强好胜、争勇斗狠，而是要注重策略方法，讲求斗争艺术。抓主要矛盾、抓矛盾的主要方面是斗争的重要方法。斗争要坚持有理有利有节，合理选择斗争方式、把握斗争火候，在原则问题上寸步不让，在策略问题上灵活机动。要根据形势需要，把握时、度、效，及时调整斗争策略。要团结一切可以团结的力量，调动一切积极因素，在斗争中争取团结，在斗争中谋求合作，" +
                    "在斗争中争取共赢。要坚持走群众路线，使人民群众在斗争中辨是非、" +
                    "明方向，不断夯实党执政的阶级基础和群众基础。",
            "斗争精神、斗争本领，不是与生俱来的，不会随着党龄增加、" +
                    "职务升迁自然提高。领导干部要经受严格的思想淬炼、政治历练、实践锻炼，在复杂严峻的斗争中经风雨、见世面、壮筋骨，真正锻造成为烈火真金。要学懂弄通做实党的创新理论，掌握马克思主义立场观点方法，夯实敢于斗争、善于斗争的思想根基，理论上清醒，政治上才能坚定，斗争起来才有底气、才有力量。要坚持在重大斗争中磨砺，越是困难大、矛盾多的地方，越是形势严峻、情况复杂的时候，越能练胆魄、磨意志、长才干。主动投身到各种斗争中去，多经历“风吹浪打”，" +
                    "多捧“烫手山芋”，当几回“热锅上的蚂蚁”，才能不断砥砺斗争精神、切实增强斗争本领。",
            "实现伟大梦想，必须进行伟大斗争。今天，全面从严治党、" +
                    "坚持马克思主义在意识形态领域的指导地位、全面深化改革、推进供给侧结构性改革、推动高质量发展、消除金融领域隐患、保障和改善民生、打赢脱贫攻坚战、治理生态环境、应对重大自然灾害、全面依法治国、处理群体性事件、打击黑恶势力、维护国家安全……对领导干部来说，斗争并不是很远，斗争就在身边。不做爱惜羽毛的“绅士”，做敢于斗争、善于斗争的战士，把初心和使命落实到本职岗位上、一言一行中，" +
                    "我们就能为实现“两个一百年”奋斗目标、实现中华民族伟大复兴的中国梦作出",
            "刘军建已在生猪养殖行业干了22年，从10头猪发展起来，规模最大时存栏超过1.2万头。此前几个月" +
                    "，受非洲猪瘟疫情影响，刘军建的养殖场存栏量在减少。但从6月开始逐步回升，现在存栏近6000头。虽然当下非洲猪瘟防疫压力仍然较大，但刘军建格外“淡定”。" +
                    "“现在国家和省里防疫工作高标准、严要求，县里经常派人过来指导，疫情肯定能控制得住。”刘军建说。",
            "性平等教师刘育豪批评称，柯文哲口中的“退出比赛”是真正该谴责的地方，因为不管林志玲是否怀孕，" +
                    "他都是在“用讪笑的说法暗喻她失去市场竞争力……女人不是工具，她们是活生生有着喜怒哀乐的个体”。律师黄帝颖称，柯文哲恐害惨台大医院，将消息走漏的医生恐面临有期徒刑以及最高35万元新台币的罚款。台“医师法”规定，医生因业务而知悉或持有病人病情或健康信息，不得无故泄露。台北市议员游淑慧还批评柯为拼网络声量，连" +
                    "林志玲怀孕与否都去蹭，“为了天天上新闻、搏版面，什么人的豆腐都吃”。(程东)"
    };
    private TextView tvTitle;
    private EditText content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initView();
    }

    private void initView() {
        listView = findViewById(R.id.news_left);
        tvTitle = findViewById(R.id.tv_title);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, titles);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                content.setText(contents[position]);
                tvTitle.setText(titles[position]);
            }
        });

        content = findViewById(R.id.editcontent);

    }
}
