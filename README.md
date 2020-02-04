# LuckyMobsMod
全てのMobがLuckyBlockになった世界

## 対応バージョン
Minecraft: 1.14.4<br>
Minecraft Forge: 28.0.45以上<br>
https://files.minecraftforge.net/maven/net/minecraftforge/forge/index_1.14.4.html<br>
Lucky Block: 7.9.1<br>
http://www.minecraftascending.com/projects/lucky_block/download/lucky_block_download.html

## 概説
Mobを倒すとLuckyBlockの効果が発動します。<br>
それだけです。

## リソースパック
MobのテクスチャはModファイルに組み込まれてあります。<br>
有効化するには、ゲーム内でリソースパック設定から"Mod Resources"を最上位にしてください。<br>
もし何らかの不都合がある場合、以下のURLから個別にリソースパックとしてダウンロードできます。<br>


## configファイル
Modを導入した状態で一回でも起動すると、configフォルダ内にdietmod-client.tomlが生成されます。<br>
値の変更は次回の起動時に適用されます。
- enable_on_creative
  - クリエイティブでMobを倒したときに効果が発動するかどうかです。<br>
    trueかfalseで指定でき、デフォルトはfalseです。
- luck_show_chat
  - ベースModのLuckyBlockはLuckという値で発動する効果の良し悪しを決定しています。<br>
    本来はラッキーブロック自身にLuckが設定されていますが、<br>
    このModではMobを倒したときに、Luckの値を100～100の範囲からランダムで抽選しています。<br>
    このLuck値をチャットに表示するかどうかです。<br>
    trueかfalseで指定でき、デフォルトはfalseです。

## 注意点
- シングルプレイのみ対応です。