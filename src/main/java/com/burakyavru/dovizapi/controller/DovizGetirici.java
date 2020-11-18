/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.burakyavru.dovizapi.controller;

import com.burakyavru.dovizapi.model.ParaBirimi;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author ismai
 */
public class DovizGetirici {

    public List<ParaBirimi> getKurList() {
        List<ParaBirimi> kurlar = new ArrayList<>();
        try {
            Document doc = Jsoup.connect("https://kur.doviz.com/")
                    .userAgent("Mozilla/5.0")
                    .referrer("https://www.google.com").timeout(0)
                    .followRedirects(true).get();

            Elements htmlKurlar = doc.select("div > table > tbody > tr");

            for (Element e : htmlKurlar) {
                if (!e.getElementsByTag("tr").attr("data-table-subpage-key").equals("")) {
                    String kur = e.getElementsByTag("tr").attr("data-table-subpage-key");
                    double alis = dovizGosteriminiDuzelt(e.getElementsByClass("text-bold").get(0).text());
                    double satis = dovizGosteriminiDuzelt(e.getElementsByClass("text-bold").get(1).text());
                    ParaBirimi pb = new ParaBirimi(kur, alis, satis);
                    kurlar.add(pb);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kurlar;
    }

    private static double dovizGosteriminiDuzelt(String deger) {
        String virgulsuz = deger.replace(",", ".");
        return Double.valueOf(virgulsuz);
    }
}
