package com.zalthrion.smallcompanions.utility;

import java.util.ArrayList;

import net.minecraft.util.text.translation.I18n;

import com.zalthrion.smallcompanions.reference.Reference;

public class TooltipHelper {
	public static ArrayList<String> add(String unlocalized) {
		ArrayList<String> ret = new ArrayList<String>();
		if (I18n.canTranslate(unlocalized)) {
			String translated = I18n.translateToLocal(unlocalized);
			if (translated.contains("\\n")) {
				String[] split = translated.split("\\\\n");
				for (int i = 0; i < split.length; i ++) {
					ret.add(split[i]);
				}
				return ret;
			} else {
				ret.add(I18n.translateToLocal(unlocalized));
				return ret;
			}
		}
		ret.add(unlocalized);
		return ret;
	}
	
	public static ArrayList<String> addAll(String unlocalized) {
		return add("tooltip." + Reference.RESOURCE_PREFIX + unlocalized);
	}
}