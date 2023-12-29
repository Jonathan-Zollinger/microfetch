package com.github.jonathan.zollinger.model;

import com.diogonunes.jcolor.Attribute;
import picocli.CommandLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public enum AsciiEnum {
    AIX("""
            ${c1}           `:+ssssossossss+-`
                    .oys///oyhddddhyo///sy+.
                  /yo:+hNNNNNNNNNNNNNNNNh+:oy/
                :h/:yNNNNNNNNNNNNNNNNNNNNNNy-+h:
              `ys.yNNNNNNNNNNNNNNNNNNNNNNNNNNy.ys
             `h+-mNNNNNNNNNNNNNNNNNNNNNNNNNNNNm-oh
             h+-NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN.oy
            /d`mNNNNNNN/::mNNNd::m+:/dNNNo::dNNNd`m:
            h//NNNNNNN: . .NNNh  mNo  od. -dNNNNN:+y
            N.sNNNNNN+ -N/ -NNh  mNNd.   sNNNNNNNo-m
            N.sNNNNNs  +oo  /Nh  mNNs` ` /mNNNNNNo-m
            h//NNNNh  ossss` +h  md- .hm/ `sNNNNN:+y
            :d`mNNN+/yNNNNNd//y//h//oNNNNy//sNNNd`m-
             yo-NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNm.ss
             `h+-mNNNNNNNNNNNNNNNNNNNNNNNNNNNNm-oy
               sy.yNNNNNNNNNNNNNNNNNNNNNNNNNNs.yo
                :h+-yNNNNNNNNNNNNNNNNNNNNNNs-oh-
                  :ys:/yNNNNNNNNNNNNNNNmy/:sy:
                    .+ys///osyhhhhys+///sy+.
                        -/osssossossso/-
            """, new Attribute[][]{new Attribute[]{GREEN_TEXT()}}),

    ALMA_LINUX("""
            ${c1}         'c:.
            ${c1}        lkkkx, ..       ${c2}..   ,cc,
            ${c1}        okkkk:ckkx'  ${c2}.lxkkx.okkkkd
            ${c1}        .:llcokkx'  ${c2}:kkkxkko:xkkd,
            ${c1}      .xkkkkdood:  ${c2};kx,  .lkxlll;
            ${c1}       xkkx.       ${c2}xk'     xkkkkk:
            ${c1}       'xkx.       ${c2}xd      .....,.
            ${c3}      .. ${c1}:xkl'     ${c2}:c      ..''..
            ${c3}    .dkx'  ${c1}.:ldl:'. ${c2}'  ${c4}':lollldkkxo;
            ${c3}  .''lkkko'                     ${c4}ckkkx.
            ${c3}'xkkkd:kkd.       ..  ${c5};'        ${c4}:kkxo.
            ${c3},xkkkd;kk'      ,d;    ${c5}ld.   ${c4}':dkd::cc,
            ${c3} .,,.;xkko'.';lxo.      ${c5}dx,  ${c4}:kkk'xkkkkc
            ${c3}     'dkkkkkxo:.        ${c5};kx  ${c4}.kkk:;xkkd.
            ${c3}       .....   ${c5}.;dk:.   ${c5}lkk.  ${c4}:;,
                         ${c5}:kkkkkkkdoxkkx
                          ,c,,;;;:xkkd.
                            ;kkkkl...
                            ;kkkkl
                             ,od;
            """, new Attribute[][]{new Attribute[]{
            RED_TEXT(),
            YELLOW_TEXT(),
            BLUE_TEXT(),
            GREEN_TEXT(),
            MAGENTA_TEXT()
    }}),

    ALPINE("""
            ${c1}       .hddddddddddddddddddddddh.
                  :dddddddddddddddddddddddddd:
                 /dddddddddddddddddddddddddddd/
                +dddddddddddddddddddddddddddddd+
              `sdddddddddddddddddddddddddddddddds`
             `ydddddddddddd++hdddddddddddddddddddy`
            .hddddddddddd+`  `+ddddh:-sdddddddddddh.
            hdddddddddd+`      `+y:    .sddddddddddh
            ddddddddh+`   `//`   `.`     -sddddddddd
            ddddddh+`   `/hddh/`   `:s-    -sddddddd
            ddddh+`   `/+/dddddh/`   `+s-    -sddddd
            ddd+`   `/o` :dddddddh/`   `oy-    .yddd
            hdddyo+ohddyosdddddddddho+oydddy++ohdddh
            .hddddddddddddddddddddddddddddddddddddh.
             `yddddddddddddddddddddddddddddddddddy`
              `sdddddddddddddddddddddddddddddddds`
                +dddddddddddddddddddddddddddddd+
                 /dddddddddddddddddddddddddddd/
                  :dddddddddddddddddddddddddd:
                   .hddddddddddddddddddddddh.
            """, new Attribute[][]{new Attribute[]{BLUE_TEXT()}}),

    ALPINE_SMALL("""
            ${c1}   /\\\\ /\\\\
              /${c2}/ ${c1}\\\\  \\\\
             /${c2}/   ${c1}\\\\  \\\\
            /${c2}//    ${c1}\\\\  \\\\
            ${c2}//      ${c1}\\\\  \\\\
                     \\\\
            """, new Attribute[][]{new Attribute[]{BLUE_TEXT(), WHITE_TEXT()}}),

    ALTER("""
            ${c1}                      %,
                                ^WWWw
                               'wwwwww
                              !wwwwwwww
                             #`wwwwwwwww
                            @wwwwwwwwwwww
                           wwwwwwwwwwwwwww
                          wwwwwwwwwwwwwwwww
                         wwwwwwwwwwwwwwwwwww
                        wwwwwwwwwwwwwwwwwwww,
                       w~1i.wwwwwwwwwwwwwwwww,
                     3~:~1lli.wwwwwwwwwwwwwwww.
                    :~~:~?ttttzwwwwwwwwwwwwwwww
                   #<~:~~~~?llllltO-.wwwwwwwwwww
                  #~:~~:~:~~?ltlltlttO-.wwwwwwwww
                 @~:~~:~:~:~~(zttlltltlOda.wwwwwww
                @~:~~: ~:~~:~:(zltlltlO    a,wwwwww
               8~~:~~:~~~~:~~~~_1ltltu          ,www
              5~~:~~:~~:~~:~~:~~~_1ltq             N,,
             g~:~~:~~~:~~:~~:~:~~~~1q                N,
            """, new Attribute[][]{new Attribute[]{BLUE_TEXT()}}),

    AMAZON("""
            ${c1}             `-/oydNNdyo:.`
                  `.:+shmMMMMMMMMMMMMMMmhs+:.`
                -+hNNMMMMMMMMMMMMMMMMMMMMMMNNho-
            .``      -/+shmNNMMMMMMNNmhs+/-      ``.
            dNmhs+:.       `.:/oo/:.`       .:+shmNd
            dMMMMMMMNdhs+:..        ..:+shdNMMMMMMMd
            dMMMMMMMMMMMMMMNds    odNMMMMMMMMMMMMMMd
            dMMMMMMMMMMMMMMMMh    yMMMMMMMMMMMMMMMMd
            dMMMMMMMMMMMMMMMMh    yMMMMMMMMMMMMMMMMd
            dMMMMMMMMMMMMMMMMh    yMMMMMMMMMMMMMMMMd
            dMMMMMMMMMMMMMMMMh    yMMMMMMMMMMMMMMMMd
            dMMMMMMMMMMMMMMMMh    yMMMMMMMMMMMMMMMMd
            dMMMMMMMMMMMMMMMMh    yMMMMMMMMMMMMMMMMd
            dMMMMMMMMMMMMMMMMh    yMMMMMMMMMMMMMMMMd
            dMMMMMMMMMMMMMMMMh    yMMMMMMMMMMMMMMMMd
            dMMMMMMMMMMMMMMMMh    yMMMMMMMMMMMMMMMMd
            .:+ydNMMMMMMMMMMMh    yMMMMMMMMMMMNdy+:.
                 `.:+shNMMMMMh    yMMMMMNhs+:``
                        `-+shy    shs+:`
            """, new Attribute[][]{new Attribute[]{YELLOW_TEXT()}}),

    ANARCHY("""
${c2}                         ..${c1}
                        ${c2}..${c1}
                      ${c2}:..${c1}
                    ${c2}:+++.${c1}
              .:::++${c2}++++${c1}+::.
          .:+######${c2}++++${c1}######+:.
       .+#########${c2}+++++${c1}##########:.
     .+##########${c2}+++++++${c1}##${c2}+${c1}#########+.
    +###########${c2}+++++++++${c1}############:
   +##########${c2}++++++${c1}#${c2}++++${c1}#${c2}+${c1}###########+
  +###########${c2}+++++${c1}###${c2}++++${c1}#${c2}+${c1}###########+
 :##########${c2}+${c1}#${c2}++++${c1}####${c2}++++${c1}#${c2}+${c1}############:
 ###########${c2}+++++${c1}#####${c2}+++++${c1}#${c2}+${c1}###${c2}++${c1}######+
.##########${c2}++++++${c1}#####${c2}++++++++++++${c1}#######.
.##########${c2}+++++++++++++++++++${c1}###########.
 #####${c2}++++++++++++++${c1}###${c2}++++++++${c1}#########+
 :###${c2}++++++++++${c1}#########${c2}+++++++${c1}#########:
  +######${c2}+++++${c1}##########${c2}++++++++${c1}#######+
   +####${c2}+++++${c1}###########${c2}+++++++++${c1}#####+
    :##${c2}++++++${c1}############${c2}++++++++++${c1}##:
     .${c2}++++++${c1}#############${c2}++++++++++${c1}+.
      :${c2}++++${c1}###############${c2}+++++++${c1}::
     .${c2}++. .:+${c1}##############${c2}+++++++${c1}..
     ${c2}.:.${c1}      ..::++++++::..:${c2}++++${c1}+.
     ${c2}.${c1}                       ${c2}.:+++${c1}.
                                ${c2}.:${c1}:
                                   ${c2}..${c1}
                                    ${c2}..${c1}
            """, new Attribute[][]{new Attribute[]{WHITE_TEXT(), BLUE_TEXT()}}),

    ANDROID("""
            ${c1}         -o          o-
                      +hydNNNNdyh+
                    +mMMMMMMMMMMMMm+
                  `dMM${c2}m:${c1}NMMMMMMN${c2}:m${c1}MMd`
                  hMMMMMMMMMMMMMMMMMMh
              ..  yyyyyyyyyyyyyyyyyyyy  ..
            .mMMm`MMMMMMMMMMMMMMMMMMMM`mMMm.
            :MMMM-MMMMMMMMMMMMMMMMMMMM-MMMM:
            :MMMM-MMMMMMMMMMMMMMMMMMMM-MMMM:
            :MMMM-MMMMMMMMMMMMMMMMMMMM-MMMM:
            :MMMM-MMMMMMMMMMMMMMMMMMMM-MMMM:
            -MMMM-MMMMMMMMMMMMMMMMMMMM-MMMM-
             +yy+ MMMMMMMMMMMMMMMMMMMM +yy+
                  mMMMMMMMMMMMMMMMMMMm
                  `/++MMMMh++hMMMM++/`
                      MMMMo  oMMMM
                      MMMMo  oMMMM
                      oNMm-  -mMNs
            """, new Attribute[][]{new Attribute[]{GREEN_TEXT(), WHITE_TEXT()}}),

    ANTERGOS("""
            ${c2}              `.-/::/-``
                        .-/osssssssso/.
                       :osyysssssssyyys+-
                    `.+yyyysssssssssyyyyy+.
                   `/syyyyyssssssssssyyyyys-`
                  `/yhyyyyysss${c1}++${c2}ssosyyyyhhy/`
                 .ohhhyyyys${c1}o++/+o${c2}so${c1}+${c2}syy${c1}+${c2}shhhho.
                .shhhhys${c1}oo++//+${c2}sss${c1}+++${c2}yyy${c1}+s${c2}hhhhs.
               -yhhhhs${c1}+++++++o${c2}ssso${c1}+++${c2}yyy${c1}s+o${c2}hhddy:
              -yddhhy${c1}o+++++o${c2}syyss${c1}++++${c2}yyy${c1}yooy${c2}hdddy-
             .yddddhs${c1}o++o${c2}syyyyys${c1}+++++${c2}yyhh${c1}sos${c2}hddddy`
            `odddddhyosyhyyyyyy${c1}++++++${c2}yhhhyosddddddo
            .dmdddddhhhhhhhyyyo${c1}+++++${c2}shhhhhohddddmmh.
            ddmmdddddhhhhhhhso${c1}++++++${c2}yhhhhhhdddddmmdy
            dmmmdddddddhhhyso${c1}++++++${c2}shhhhhddddddmmmmh
            -dmmmdddddddhhys${c1}o++++o${c2}shhhhdddddddmmmmd-
            .smmmmddddddddhhhhhhhhhdddddddddmmmms.
               `+ydmmmdddddddddddddddddddmmmmdy/.
                  `.:+ooyyddddddddddddyyso+:.`
            """, new Attribute[][]{new Attribute[]{WHITE_TEXT(), BLUE_TEXT()}}),

    ANTIX("""
            ${c1}
                                \\
                     , - ~ ^ ~ - \\        /
                 , '              \\ ' ,  /
               ,                   \\   '/
              ,                     \\  / ,
             ,___,                   \\/   ,
             /   |   _  _  _|_ o     /\\   ,
            |,   |  / |/ |  |  |    /  \\  ,
             \\,_/\\_/  |  |_/|_/|_/_/    \\,
               ,                  /     ,\\
                 ,               /  , '   \\
                  ' - , _ _ _ ,
            """, new Attribute[][]{new Attribute[]{WHITE_TEXT()}}),

    AOSC_OS("""
            ${c2}             .:+syhhhhys+:.
                     .ohNMMMMMMMMMMMMMMNho.
                  `+mMMMMMMMMMMmdmNMMMMMMMMm+`
                 +NMMMMMMMMMMMM/   `./smMMMMMN+
               .mMMMMMMMMMMMMMMo        -yMMMMMm.
              :NMMMMMMMMMMMMMMMs          .hMMMMN:
             .NMMMMhmMMMMMMMMMMm+/-         oMMMMN.
             dMMMMs  ./ymMMMMMMMMMMNy.       sMMMMd
            -MMMMN`      oMMMMMMMMMMMN:      `NMMMM-
            /MMMMh       NMMMMMMMMMMMMm       hMMMM/
            /MMMMh       NMMMMMMMMMMMMm       hMMMM/
            -MMMMN`      :MMMMMMMMMMMMy.     `NMMMM-
             dMMMMs       .yNMMMMMMMMMMMNy/. sMMMMd
             .NMMMMo         -/+sMMMMMMMMMMMmMMMMN.
              :NMMMMh.          .MMMMMMMMMMMMMMMN:
               .mMMMMMy-         NMMMMMMMMMMMMMm.
                 +NMMMMMms/.`    mMMMMMMMMMMMN+
                  `+mMMMMMMMMNmddMMMMMMMMMMm+`
                     .ohNMMMMMMMMMMMMMMNho.
                         .:+syhhhhys+:.
            """, new Attribute[][]{new Attribute[]{YELLOW_TEXT(), RED_TEXT()}}),
    AOSC_OS_RETRO("""
            ${c2}          .........
                 ...................
               .....................${c1}################${c2}
             ..............     ....${c1}################${c2}
            ..............       ...${c1}################${c2}
            .............         ..${c1}****************${c2}
            ............     .     .${c1}****************${c2}
            ...........     ...     ${c1}................${c2}
            ..........     .....     ${c1}...............${c2}
            .........     .......     ...
             .${c3}......                   ${c2}.
              ${c3}.....      .....${c2}....    ${c4}...........
              ${c3}....      ......${c2}.       ${c4}...........
              ${c3}...      .......        ${c4}...........
              ${c3}................        ${c4}***********
              ${c3}................        ${c4}###########
              ${c3}****************
              ${c3}################
            """, new Attribute[][]{new Attribute[]{ BLUE_TEXT(), WHITE_TEXT(), RED_TEXT(), YELLOW_TEXT()}}),
    APERIO_GNU_LINUX("""
            ${c1} _.._  _ ._.. _
            (_][_)(/,[  |(_)
               |   GNU/Linux
            """, new Attribute[][]{new Attribute[]{WHITE_TEXT()}}),

    APRICITY("""
            ${c1}                                    ./o-
                      ``...``              `:. -/:
                 `-+ymNMMMMMNmho-`      :sdNNm/
               `+dMMMMMMMMMMMMMMMmo` sh:.:::-
              /mMMMMMMMMMMMMMMMMMMMm/`sNd/
             oMMMMMMMMMMMMMMMMMMMMMMMs -`
            :MMMMMMMMMMMMMMMMMMMMMMMMM/
            NMMMMMMMMMMMMMMMMMMMMMMMMMd
            MMMMMMMmdmMMMMMMMMMMMMMMMMd
            MMMMMMy` .mMMMMMMMMMMMmho:`
            MMMMMMNo/sMMMMMMMNdy+-.`-/
            MMMMMMMMMMMMNdy+:.`.:ohmm:
            MMMMMMMmhs+-.`.:+ymNMMMy.
            MMMMMM/`.-/ohmNMMMMMMy-
            MMMMMMNmNNMMMMMMMMmo.
            MMMMMMMMMMMMMMMms:`
            MMMMMMMMMMNds/.
            dhhyys+/-`
            """, new Attribute[][]{new Attribute[]{WHITE_TEXT()}}),

    ARCH("""
            ${c1}                   -`
                              .o+`
                             `ooo/
                            `+oooo:
                           `+oooooo:
                           -+oooooo+:
                         `/:-:++oooo+:
                        `/++++/+++++++:
                       `/++++++++++++++:
                      `/+++o${c2}oooooooo${c1}oooo/`
            ${c2}         ${c1}./${c2}ooosssso++osssssso${c1}+`
            ${c2}        .oossssso-````/ossssss+`
                   -osssssso.      :ssssssso.
                  :osssssss/        osssso+++.
                 /ossssssss/        +ssssooo/-
               `/ossssso+/:-        -:/+osssso+-
              `+sso+:-`                 `.-/+oso:
             `++:.                           `-/+/
             .`                                 `/
            """, new Attribute[][]{new Attribute[]{BLUE_TEXT(), WHITE_TEXT()}}),

    ARCH_OLD("""
            ${c1}             __
                     _=(SDGJT=_
                   _GTDJHGGFCVS)
                  ,GTDJGGDTDFBGX0
            ${c1}     JDJDIJHRORVFSBSVL${c2}-=+=,_
            ${c1}    IJFDUFHJNXIXCDXDSV,${c2}  "DEBL
            ${c1}   [LKDSDJTDU=OUSCSBFLD.${c2}   '?ZWX,
            ${c1}  ,LMDSDSWH'     `DCBOSI${c2}     DRDS],
            ${c1}  SDDFDFH'         !YEWD,${c2}   )HDROD
            ${c1} !KMDOCG            &GSU|${c2}\\_GFHRGO\\'
            ${c1} HKLSGP'${c2}           __${c1}\\TKM0${c2}\\GHRBV)'
            ${c1}JSNRVW'${c2}       __+MNAEC${c1}\\IOI,${c2}\\BN'
            ${c1}HELK['${c2}    __,=OFFXCBGHC${c1}\\FD)
            ${c1}?KGHE ${c2}\\_-#DASDFLSV='${c1}    'EF
            'EHTI                    !H
             `0F'                    '!
            """, new Attribute[][]{new Attribute[]{BLUE_TEXT(), WHITE_TEXT()}}),

    ARCH_SMALL("""
            ${c1}      /\\
                 /  \\
                /\\   \\
            ${c2}   /      \\
              /   ,,   \\
             /   |  |  -\\
            /_-''    ''-_\\
            """, new Attribute[][]{new Attribute[]{BLUE_TEXT(), WHITE_TEXT()}}),

    ARCH_BOX("""
            ${c1}              ...:+oh/:::..
                     ..-/oshhhhhh`   `::::-.
                 .:/ohhhhhhhhhhhh`        `-::::.
             .+shhhhhhhhhhhhhhhhh`             `.::-.
             /`-:+shhhhhhhhhhhhhh`            .-/+shh
             /      .:/ohhhhhhhhh`       .:/ohhhhhhhh
             /           `-:+shhh`  ..:+shhhhhhhhhhhh
             /                 .:ohhhhhhhhhhhhhhhhhhh
             /                  `hhhhhhhhhhhhhhhhhhhh
             /                  `hhhhhhhhhhhhhhhhhhhh
             /                  `hhhhhhhhhhhhhhhhhhhh
             /                  `hhhhhhhhhhhhhhhhhhhh
             /      .+o+        `hhhhhhhhhhhhhhhhhhhh
             /     -hhhhh       `hhhhhhhhhhhhhhhhhhhh
             /     ohhhhho      `hhhhhhhhhhhhhhhhhhhh
             /:::+`hhhhoos`     `hhhhhhhhhhhhhhhhhs+`
                `--/:`   /:     `hhhhhhhhhhhho/-
                         -/:.   `hhhhhhs+:-`
                            ::::/ho/-`
            """, new Attribute[][]{new Attribute[]{GREEN_TEXT()}}),

    ARCH_CRAFT("""
            ${c1}                   -m:
                              :NMM+      .+
                             +MMMMMo    -NMy
                            sMMMMMMMy  -MMMMh`
                           yMMMMMMMMMd` oMMMMd`
                         `dMMMMMMMMMMMm. /MMMMm-
                        .mMMMMMm-dMMMMMN- :NMMMN:
                       -NMMMMMd`  yMMMMMN: .mMMMM/
                      :NMMMMMy     sMMMMMM+ `dMMMMo
                     +MMMMMMs       +MMMMMMs `hMMMMy
                    oMMMMMMMds-      :NMMMMMy  sMMMMh`
                   yMMMMMNoydMMmo`    -NMMMMMd` +MMMMd.
                 `dMMMMMN-   `:yNNs`   .mMMMMMm. /MMMMm-
                .mMMMMMm.        :hN/   `dMMMMMN- -NMMMN:
               -NMMMMMd`           -hh`  `yMMMMMN: .mMMMM/
              :NMMMMMy         `s`   :h.   oMMMMMM+ `-----
             +MMMMMMo         .dMm.   `o.   +MMMMMMo
            sMMMMMM+         .mMMMN:    :`   :NMMMMMy
            """, new Attribute[][]{new Attribute[]{CYAN_TEXT()}}),

    ARCH_LABS("""
            ${c1}                     'c'
                                'kKk,
                               .dKKKx.
                              .oKXKXKd.
                             .l0XXXXKKo.
                             c0KXXXXKX0l.
                            :0XKKOxxOKX0l.
                           :OXKOc. .c0XX0l.
                          :OK0o. ${c4}...${c1}'dKKX0l.
                         :OX0c  ${c4};xOx'${c1}'dKXX0l.
                        :0KKo.${c4}.o0XXKd'.${c1}lKXX0l.
                       c0XKd.${c4}.oKXXXXKd..${c1}oKKX0l.
                     .c0XKk;${c4}.l0K0OO0XKd..${c1}oKXXKo.
                    .l0XXXk:${c4},dKx,.'l0XKo.${c1}.kXXXKo.
                   .o0XXXX0d,${c4}:x;   .oKKx'${c1}.dXKXXKd.
                  .oKXXXXKK0c.${c4};.    :00c'${c1}cOXXXXXKd.
                 .dKXXXXXXXXk,${c4}.     cKx'${c1}'xKXXXXXXKx'
                'xKXXXXK0kdl:.     ${c4}.ok; ${c1}.cdk0KKXXXKx'
               'xKK0koc,..         ${c4}'c, ${c1}    ..,cok0KKk,
              ,xko:'.             ${c4}.. ${c1}           .':okx;
             .,'.                                   .',.
            """, new Attribute[][]{new Attribute[]{CYAN_TEXT(), CYAN_TEXT(), BRIGHT_BLACK_TEXT(), RED_TEXT()}}),

    ARCH_MERGE("""
            ${c1}                    y:
                              sMN-
                             +MMMm`
                            /MMMMMd`
                           :NMMMMMMy
                          -NMMMMMMMMs
                         .NMMMMMMMMMM+
                        .mMMMMMMMMMMMM+
                        oNMMMMMMMMMMMMM+
                      `+:-+NMMMMMMMMMMMM+
                      .sNMNhNMMMMMMMMMMMM/
                    `hho/sNMMMMMMMMMMMMMMM/
                   `.`omMMmMMMMMMMMMMMMMMMM+
                  .mMNdshMMMMd+::oNMMMMMMMMMo
                 .mMMMMMMMMM+     `yMMMMMMMMMs
                .NMMMMMMMMM/        yMMMMMMMMMy
               -NMMMMMMMMMh         `mNMMMMMMMMd`
              /NMMMNds+:.`             `-/oymMMMm.
             +Mmy/.                          `:smN:
            /+.                                  -o.
            """, new Attribute[][]{new Attribute[]{CYAN_TEXT()}}),

    ARCH_STRIKE("""
            ${c1} \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 *\u00a0 \u00a0
            \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 **.
            \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0****
            \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 ******
            \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 *******
            \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 ** *******
            \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0**** *******
            \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 ${c1}****${c2}_____${c1}***${c2}/${c1}*
            \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 \u00a0***${c2}/${c1}*******${c2}//${c1}***
            \u00a0 \u00a0 \u00a0 \u00a0 \u00a0 **${c2}/${c1}********${c2}///${c1}*${c2}/${c1}**
            \u00a0 \u00a0 \u00a0 \u00a0 \u00a0**${c2}/${c1}*******${c2}////${c1}***${c2}/${c1}**
            \u00a0 \u00a0 \u00a0 \u00a0 **${c2}/${c1}****${c2}//////.,${c1}****${c2}/${c1}**
            \u00a0 \u00a0 \u00a0 \u00a0***${c2}/${c1}*****${c2}/////////${c1}**${c2}/${c1}***
            \u00a0 \u00a0 \u00a0 ****${c2}/${c1}**** \u00a0 \u00a0${c2}/////${c1}***${c2}/${c1}****
            \u00a0 \u00a0 \u00a0******${c2}/${c1}***  ${c2}//// \u00a0 ${c1}**${c2}/${c1}******
            \u00a0 \u00a0 ********${c2}/${c1}* ${c2}/// \u00a0 \u00a0\u00a0 ${c1}*${c2}/${c1}********
            \u00a0 ,****** \u00a0 \u00a0 ${c2}// ______ / \u00a0 \u00a0${c1}******,
            """, new Attribute[][]{new Attribute[]{BRIGHT_BLACK_TEXT(), CYAN_TEXT()}}),

    CENTOS("""
            ${c1}                 ..
                           .PLTJ.
                          <><><><>
                 ${c2}KKSSV' 4KKK ${c1}LJ${c4} KKKL.'VSSKK
                 ${c2}KKV' 4KKKKK ${c1}LJ${c4} KKKKAL 'VKK
                 ${c2}V' ' 'VKKKK ${c1}LJ${c4} KKKKV' ' 'V
                 ${c2}.4MA.' 'VKK ${c1}LJ${c4} KKV' '.4Mb.
            ${c4}   . ${c2}KKKKKA.' 'V ${c1}LJ${c4} V' '.4KKKKK ${c3}.
            ${c4} .4D ${c2}KKKKKKKA.'' ${c1}LJ${c4} ''.4KKKKKKK ${c3}FA.
            ${c4}<QDD ++++++++++++  ${c3}++++++++++++ GFD>
            ${c4} 'VD ${c3}KKKKKKKK'.. ${c2}LJ ${c1}..'KKKKKKKK ${c3}FV
            ${c4}   ' ${c3}VKKKKK'. .4 ${c2}LJ ${c1}K. .'KKKKKV ${c3}'
                 ${c3} 'VK'. .4KK ${c2}LJ ${c1}KKA. .'KV'
                 ${c3}A. . .4KKKK ${c2}LJ ${c1}KKKKA. . .4
                 ${c3}KKA. 'KKKKK ${c2}LJ ${c1}KKKKK' .4KK
                 ${c3}KKSSA. VKKK ${c2}LJ ${c1}KKKV .4SSKK
            ${c2}              <><><><>
                           'MKKM'
                             ''
            """, new Attribute[][]{new Attribute[]{
            YELLOW_TEXT(),
            GREEN_TEXT(),
            BLUE_TEXT(),
            MAGENTA_TEXT(),
            TEXT_COLOR(7)}}),

    CENTOS_SMALL("""
            ${c2} ____${c1}^${c4}____
            ${c2} |\\  ${c1}|${c4}  /|
            ${c2} | \\ ${c1}|${c4} / |
            ${c4}<---- ${c3}---->
            ${c3} | / ${c2}|${c1} \\ |
            ${c3} |/__${c2}|${c1}__\\|
            ${c2}     v
            """, new Attribute[][]{new Attribute[]{
            YELLOW_TEXT(),
            GREEN_TEXT(),
            BLUE_TEXT(),
            MAGENTA_TEXT(),
            TEXT_COLOR(7)}}),

    CUCUMBER("""
            ${c1}           `.-://++++++//:-.`
                    `:/+//${c2}::--------${c1}:://+/:`
                  -++/:${c2}----..........----${c1}:/++-
                .++:${c2}---...........-......---${c1}:++.
               /+:${c2}---....-::/:/--//:::-....---${c1}:+/
             `++:${c2}--.....:---::/--/::---:.....--${c1}:++`
             /+:${c2}--.....--.--::::-/::--.--.....--${c1}:+/
            -o:${c2}--.......-:::://--/:::::-.......--${c1}:o-
            /+:${c2}--...-:-::---:::..:::---:--:-...--${c1}:+/
            o/:${c2}-...-:.:.-/:::......::/:.--.:-...-${c1}:/o
            o/${c2}--...::-:/::/:-......-::::::-/-...-${c1}:/o
            /+:${c2}--..-/:/:::--:::..:::--::////-..--${c1}:+/
            -o:${c2}--...----::/:::/--/:::::-----...--${c1}:o-
             /+:${c2}--....://:::.:/--/:.::://:....--${c1}:+/
             `++:${c2}--...-:::.--.:..:.--.:/:-...--${c1}:++`
               /+:${c2}---....----:-..-:----....---${c1}:+/
                .++:${c2}---..................---${c1}:++.
                  -/+/:${c2}----..........----${c1}:/+/-
                    `:/+//${c2}::--------:::${c1}/+/:`
                       `.-://++++++//:-.`
            """, new Attribute[][]{new Attribute[]{
            GREEN_TEXT(),
            YELLOW_TEXT()}}),

    DEBIAN("""
            ${c2}       _,met$$$$$gg.
                ,g$$$$$$$$$$$$$$$P.
              ,g$$P"        ""\"Y$$.".
             ,$$P'              `$$$.
            ',$$P       ,ggs.     `$$b:
            `d$$'     ,$P"'   ${c1}.${c2}    $$$
             $$P      d$'     ${c1},${c2}    $$P
             $$:      $$.   ${c1}-${c2}    ,d$$'
             $$;      Y$b._   _,d$P'
             Y$$.    ${c1}`.${c2}`"Y$$$$P"'
            ${c2} `$$b      ${c1}"-.__
            ${c2}  `Y$$
               `Y$$.
                 `$$b.
                   `Y$$b.
                      `"Y$b._
                          `""\"
            """, new Attribute[][]{new Attribute[]{
            RED_TEXT(),
            TEXT_COLOR(7)}}),

    DEBIAN_SMALL("""
            ${c1}  _____
             /  __ \\
            |  /    |
            |  \\___-
            -_
              --_
            """, new Attribute[][]{new Attribute[]{RED_TEXT()}}),

    FEDORA("""
            ${c1}             .',;::::;,'.
                     .';:cccccccccccc:;,.
                  .;cccccccccccccccccccccc;.
                .:cccccccccccccccccccccccccc:.
              .;ccccccccccccc;${c2}.:dddl:.${c1};ccccccc;.
             .:ccccccccccccc;${c2}OWMKOOXMWd${c1};ccccccc:.
            .:ccccccccccccc;${c2}KMMc${c1};cc;${c2}xMMc${c1};ccccccc:.
            ,cccccccccccccc;${c2}MMM.${c1};cc;${c2};WW:${c1};cccccccc,
            :cccccccccccccc;${c2}MMM.${c1};cccccccccccccccc:
            :ccccccc;${c2}oxOOOo${c1};${c2}MMM0OOk.${c1};cccccccccccc:
            cccccc;${c2}0MMKxdd:${c1};${c2}MMMkddc.${c1};cccccccccccc;
            ccccc;${c2}XM0'${c1};cccc;${c2}MMM.${c1};cccccccccccccccc'
            ccccc;${c2}MMo${c1};ccccc;${c2}MMW.${c1};ccccccccccccccc;
            ccccc;${c2}0MNc.${c1}ccc${c2}.xMMd${c1};ccccccccccccccc;
            cccccc;${c2}dNMWXXXWM0:${c1};cccccccccccccc:,
            cccccccc;${c2}.:odl:.${c1};cccccccccccccc:,.
            :cccccccccccccccccccccccccccc:'.
            .:cccccccccccccccccccccc:;,..
              '::cccccccccccccc::;,.
                        """, new Attribute[][]{new Attribute[]{BLUE_TEXT(), WHITE_TEXT()}}),

    FEDORA_OLD("""
            ${c1}          /:-------------:\\
                   :-------------------::
                 :-----------${c2}/shhOHbmp${c1}---:\\
               /-----------${c2}omMMMNNNMMD  ${c1}---:
              :-----------${c2}sMMMMNMNMP${c1}.    ---:
             :-----------${c2}:MMMdP${c1}-------    ---\\
            ,------------${c2}:MMMd${c1}--------    ---:
            :------------${c2}:MMMd${c1}-------    .---:
            :----    ${c2}oNMMMMMMMMMNho${c1}     .----:
            :--     .${c2}+shhhMMMmhhy++${c1}   .------/
            :-    -------${c2}:MMMd${c1}--------------:
            :-   --------${c2}/MMMd${c1}-------------;
            :-    ------${c2}/hMMMy${c1}------------:
            :--${c2} :dMNdhhdNMMNo${c1}------------;
            :---${c2}:sdNMMMMNds:${c1}------------:
            :------${c2}:://:${c1}-------------::
            :---------------------://
            """, new Attribute[][]{new Attribute[]{BLUE_TEXT(), WHITE_TEXT()}}),

    FEDORA_SMALL("""
            ${c1}        ,'''''.
                   |   ,.  |
                   |  |  '_'
              ,....|  |..
            .'  ,_;|   ..'
            |  |   |  |
            |  ',_,'  |
             '.     ,'
               '''''
            """, new Attribute[][]{new Attribute[]{BLUE_TEXT()}}),

    KALI("""
            ${c1}..............
                        ..,;:ccc,.
                      ......''';lxO.
            .....''''..........,:ld;
                       .';;;:::;,,.x,
                  ..'''.            0Xxoc:,.  ...
              ....                ,ONkc;,;cokOdc',.
             .                   OMo           ':${c2}dd${c1}o.
                                dMc               :OO;
                                0M.                 .:o.
                                ;Wd
                                 ;XO,
                                   ,d0Odlc;,..
                                       ..',;:cdOOd::,.
                                                .:d;.':;.
                                                   'd,  .'
                                                     ;l   ..
                                                      .o
                                                        c
                                                        .'
                                                         .
            """, new Attribute[][]{new Attribute[]{BLUE_TEXT(), WHITE_TEXT()}}),

    KDE("""
            ${c1}             `..---+/---..`
                     `---.``   ``   `.---.`
                  .--.`        ``        `-:-.
                `:/:     `.----//----.`     :/-
               .:.    `---`          `--.`    .:`
              .:`   `--`                .:-    `:.
             `/    `:.      `.-::-.`      -:`   `/`
             /.    /.     `:++++++++:`     .:    .:
            `/    .:     `+++++++++++/      /`   `+`
            /+`   --     .++++++++++++`     :.   .+:
            `/    .:     `+++++++++++/      /`   `+`
             /`    /.     `:++++++++:`     .:    .:
             ./    `:.      `.:::-.`      -:`   `/`
              .:`   `--`                .:-    `:.
               .:.    `---`          `--.`    .:`
                `:/:     `.----//----.`     :/-
                  .-:.`        ``        `-:-.
                     `---.``   ``   `.---.`
                         `..---+/---..`
            """, new Attribute[][]{new Attribute[]{GREEN_TEXT()}}),

    KUBUNTU("""
            ${c1}           `.:/ossyyyysso/:.
                    .:oyyyyyyyyyyyyyyyyyyo:`
                  -oyyyyyyyo${c2}dMMy${c1}yyyyyyysyyyyo-
                -syyyyyyyyyy${c2}dMMy${c1}oyyyy${c2}dmMMy${c1}yyyys-
               oyyys${c2}dMy${c1}syyyy${c2}dMMMMMMMMMMMMMy${c1}yyyyyyo
             `oyyyy${c2}dMMMMy${c1}syysoooooo${c2}dMMMMy${c1}yyyyyyyyo`
             oyyyyyy${c2}dMMMMy${c1}yyyyyyyyyyys${c2}dMMy${c1}sssssyyyo
            -yyyyyyyy${c2}dMy${c1}syyyyyyyyyyyyyys${c2}dMMMMMy${c1}syyy-
            oyyyysoo${c2}dMy${c1}yyyyyyyyyyyyyyyyyy${c2}dMMMMy${c1}syyyo
            yyys${c2}dMMMMMy${c1}yyyyyyyyyyyyyyyyyysosyyyyyyyy
            yyys${c2}dMMMMMy${c1}yyyyyyyyyyyyyyyyyyyyyyyyyyyyy
            oyyyyysos${c2}dy${c1}yyyyyyyyyyyyyyyyyy${c2}dMMMMy${c1}syyyo
            -yyyyyyyy${c2}dMy${c1}syyyyyyyyyyyyyys${c2}dMMMMMy${c1}syyy-
             oyyyyyy${c2}dMMMy${c1}syyyyyyyyyyys${c2}dMMy${c1}oyyyoyyyo
             `oyyyy${c2}dMMMy${c1}syyyoooooo${c2}dMMMMy${c1}oyyyyyyyyo
               oyyysyyoyyyys${c2}dMMMMMMMMMMMy${c1}yyyyyyyo
                -syyyyyyyyy${c2}dMMMy${c1}syyy${c2}dMMMy${c1}syyyys-
                  -oyyyyyyy${c2}dMMy${c1}yyyyyysosyyyyo-
                    ./oyyyyyyyyyyyyyyyyyyo/.
                       `.:/oosyyyysso/:.`
            """, new Attribute[][]{new Attribute[]{BLUE_TEXT(), WHITE_TEXT()}}),

    LINUX("""
            ${c2}        #####
            ${c2}       #######
            ${c2}       ##${c1}O${c2}#${c1}O${c2}##
            ${c2}       #${c3}#####${c2}#
            ${c2}     ##${c1}##${c3}###${c1}##${c2}##
            ${c2}    #${c1}##########${c2}##
            ${c2}   #${c1}############${c2}##
            ${c2}   #${c1}############${c2}###
            ${c3}  ##${c2}#${c1}###########${c2}##${c3}#
            ${c3}######${c2}#${c1}#######${c2}#${c3}######
            ${c3}#######${c2}#${c1}#####${c2}#${c3}#######
            ${c3}  #####${c2}#######${c3}#####
            """, new Attribute[][]{new Attribute[]{
            BLUE_TEXT(), TEXT_COLOR(7), RED_TEXT()}}),

    LINUX_MINT("""
                        ${c2}             ...-:::::-...
            ${c2}          .-MMMMMMMMMMMMMMM-.
                  .-MMMM${c1}`..-:::::::-..`${c2}MMMM-.
                .:MMMM${c1}.:MMMMMMMMMMMMMMM:.${c2}MMMM:.
               -MMM${c1}-M---MMMMMMMMMMMMMMMMMMM.${c2}MMM-
             `:MMM${c1}:MM`  :MMMM:....::-...-MMMM:${c2}MMM:`
             :MMM${c1}:MMM`  :MM:`  ``    ``  `:MMM:${c2}MMM:
            .MMM${c1}.MMMM`  :MM.  -MM.  .MM-  `MMMM.${c2}MMM.
            :MMM${c1}:MMMM`  :MM.  -MM-  .MM:  `MMMM-${c2}MMM:
            :MMM${c1}:MMMM`  :MM.  -MM-  .MM:  `MMMM:${c2}MMM:
            :MMM${c1}:MMMM`  :MM.  -MM-  .MM:  `MMMM-${c2}MMM:
            .MMM${c1}.MMMM`  :MM:--:MM:--:MM:  `MMMM.${c2}MMM.
             :MMM${c1}:MMM-  `-MMMMMMMMMMMM-`  -MMM-${c2}MMM:
              :MMM${c1}:MMM:`                `:MMM:${c2}MMM:
               .MMM${c1}.MMMM:--------------:MMMM.${c2}MMM.
                 '-MMMM${c1}.-MMMMMMMMMMMMMMM-.${c2}MMMM-'
                   '.-MMMM${c1}``--:::::--``${c2}MMMM-.'
            ${c2}            '-MMMMMMMMMMMMM-'
            ${c2}               ``-:::::-``

            """, new Attribute[][]{new Attribute[]{
            GREEN_TEXT(), TEXT_COLOR(7)}}),

    LINUX_MINT_OLD("""
            ${c1}MMMMMMMMMMMMMMMMMMMMMMMMMmds+.
            MMm----::-://////////////oymNMd+`
            MMd      ${c2}/++                ${c1}-sNMd:
            MMNso/`  ${c2}dMM    `.::-. .-::.` ${c1}.hMN:
            ddddMMh  ${c2}dMM   :hNMNMNhNMNMNh: ${c1}`NMm
                NMm  ${c2}dMM  .NMN/-+MMM+-/NMN` ${c1}dMM
                NMm  ${c2}dMM  -MMm  `MMM   dMM. ${c1}dMM
                NMm  ${c2}dMM  -MMm  `MMM   dMM. ${c1}dMM
                NMm  ${c2}dMM  .mmd  `mmm   yMM. ${c1}dMM
                NMm  ${c2}dMM`  ..`   ...   ydm. ${c1}dMM
                hMM- ${c2}+MMd/-------...-:sdds  ${c1}dMM
                -NMm- ${c2}:hNMNNNmdddddddddy/`  ${c1}dMM
                 -dMNs-${c2}``-::::-------.``    ${c1}dMM
                  `/dMNmy+/:-------------:/yMMM
                     ./ydNMMMMMMMMMMMMMMMMMMMMM
                        .MMMMMMMMMMMMMMMMMMM
             """, new Attribute[][]{new Attribute[]{
            GREEN_TEXT(), TEXT_COLOR(7)}}),
    LINUXMINT_SMALL("""
            ${c1} ___________
            |_          \\
              | ${c2}| _____ ${c1}|
              | ${c2}| | | | ${c1}|
              | ${c2}| | | | ${c1}|
              | ${c2}\\__${c2}___/ ${c1}|
              \\_________/
            """, new Attribute[][]{new Attribute[]{
            GREEN_TEXT(), TEXT_COLOR(7)}}),

    MAC("""
            ${c1}                    c.'
                             ,xNMM.
                           .OMMMMo
                           lMM"
                 .;loddo:.  .olloddol;.
               cKMMMMMMMMMMNWMMMMMMMMMM0:
            ${c2} .KMMMMMMMMMMMMMMMMMMMMMMMWd.
             XMMMMMMMMMMMMMMMMMMMMMMMX.
            ${c3};MMMMMMMMMMMMMMMMMMMMMMMM:
            :MMMMMMMMMMMMMMMMMMMMMMMM:
            ${c4}.MMMMMMMMMMMMMMMMMMMMMMMMX.
             kMMMMMMMMMMMMMMMMMMMMMMMMWd.
             ${c5}'XMMMMMMMMMMMMMMMMMMMMMMMMMMk
              'XMMMMMMMMMMMMMMMMMMMMMMMMK.
                ${c6}kMMMMMMMMMMMMMMMMMMMMMMd
                 ;KMMMMMMMWXXWMMMMMMMk.
                   "cooc*"    "*coo'"
            """, new Attribute[][]{new Attribute[]{
            GREEN_TEXT(),
            YELLOW_TEXT(),
            RED_TEXT(),
            MAGENTA_TEXT(),
            BLUE_TEXT(),
            WHITE_TEXT()}}),
    MAC_SMALL("""
            ${c1}       .:'
                _ :'_
            ${c2} .'`_`-'_``.
            :________.-'
            ${c3}:_______:
            :_______:
            ${c4} :_______`-;
            ${c5}  `._.-._.'
            """, new Attribute[][]{new Attribute[]{
            GREEN_TEXT(),
            YELLOW_TEXT(),
            RED_TEXT(),
            MAGENTA_TEXT(),
            BLUE_TEXT()}}),

    SUSE("""
            ${c2}           .;ldkO0000Okdl;.
                   .;d00xl:^''''''^:ok00d;.
                 .d00l'                'o00d.
               .d0Kd'${c1}  Okxol:;,.          ${c2}:O0d.
              .OK${c1}KKK0kOKKKKKKKKKKOxo:,      ${c2}lKO.
             ,0K${c1}KKKKKKKKKKKKKKK0P^${c2},,,${c1}^dx:${c2}    ;00,
            .OK${c1}KKKKKKKKKKKKKKKk'${c2}.oOPPb.${c1}'0k.${c2}   cKO.
            :KK${c1}KKKKKKKKKKKKKKK: ${c2}kKx..dd ${c1}lKd${c2}   'OK:
            dKK${c1}KKKKKKKKKOx0KKKd ${c2}^0KKKO' ${c1}kKKc${c2}   dKd
            dKK${c1}KKKKKKKKKK;.;oOKx,..${c2}^${c1}..;kKKK0.${c2}  dKd
            :KK${c1}KKKKKKKKKK0o;...^cdxxOK0O/^^'  ${c2}.0K:
             kKK${c1}KKKKKKKKKKKKK0x;,,......,;od  ${c2}lKk
             '0K${c1}KKKKKKKKKKKKKKKKKKKK00KKOo^  ${c2}c00'
              'kK${c1}KKOxddxkOO00000Okxoc;''   ${c2}.dKk'
                l0Ko.                    .c00l'
                 'l0Kk:.              .;xK0l'
                    'lkK0xl:;,,,,;:ldO0kl'
                        '^:ldxkkkkxdl:^'
                        """, new Attribute[][]{new Attribute[]{GREEN_TEXT(), WHITE_TEXT()}}),

    SUSE_LEAP("""
            ${c1}                 `-++:`
                           ./oooooo/-
                        `:oooooooooooo:.
                      -+oooooooooooooooo+-`
                   ./oooooooooooooooooooooo/-
                  :oooooooooooooooooooooooooo:
                `  `-+oooooooooooooooooooo/-   `
             `:oo/-   .:ooooooooooooooo+:`  `-+oo/.
            `/oooooo:.   -/oooooooooo/.   ./oooooo/.
              `:+ooooo+-`  `:+oooo+-   `:oooooo+:`
                 .:oooooo/.   .::`   -+oooooo/.
                    -/oooooo:.    ./oooooo+-
                      `:+ooooo+-:+oooooo:`
                         ./oooooooooo/.
                            -/oooo+:`
                              `:/.
                        """, new Attribute[][]{new Attribute[]{GREEN_TEXT()}}),

    SUSE_SMALL("""
            ${c1}  _______
            __|   __ \\
                 / .\\ \\
                 \\__/ |
               _______|
               \\_______
            __________/
            """, new Attribute[][]{new Attribute[]{GREEN_TEXT()}}),

    SUSE_TUMBLEWEED("""
            ${c1}                                     ......
                 .,cdxxxoc,.               .:kKMMMNWMMMNk:.
                cKMMN0OOOKWMMXo. ;        ;0MWk:.      .:OMMk.
              ;WMK;.       .lKMMNM,     :NMK,             .OMW;
             cMW;            'WMMMN   ,XMK,                 oMM'
            .MMc               ..;l. xMN:                    KM0
            'MM.                   'NMO                      oMM
            .MM,                 .kMMl                       xMN
             KM0               .kMM0. .dl:,..               .WMd
             .XM0.           ,OMMK,    OMMMK.              .XMK
               oWMO:.    .;xNMMk,       NNNMKl.          .xWMx
                 :ONMMNXMMMKx;          .  ,xNMWKkxllox0NMWk,
                     .....                    .:dOOXXKOxl,
                        """, new Attribute[][]{new Attribute[]{WHITE_TEXT()}}),

    ORACLE("""
            ${c1}
                  `-/+++++++++++++++++/-.`
               `/syyyyyyyyyyyyyyyyyyyyyyys/.
              :yyyyo/-...............-/oyyyy/
             /yyys-                     .oyyy+
            .yyyy`                       `syyy-
            :yyyo                         /yyy/
            .yyyy`                       `syyy-
             /yyys.                     .oyyyo
              /yyyyo:-...............-:oyyyy/`
               `/syyyyyyyyyyyyyyyyyyyyyyys+.
                 `.:/+ooooooooooooooo+/:.`
            """, new Attribute[][]{new Attribute[]{RED_TEXT()}}),

    POP_OS("""
            ${c1}             /////////////
                     /////////////////////
                  ///////${c2}*767${c1}////////////////
                //////${c2}7676767676*${c1}//////////////
               /////${c2}76767${c1}//${c2}7676767${c1}//////////////
              /////${c2}767676${c1}///${c2}*76767${c1}///////////////
             ///////${c2}767676${c1}///${c2}76767${c1}.///${c2}7676*${c1}///////
            /////////${c2}767676${c1}//${c2}76767${c1}///${c2}767676${c1}////////
            //////////${c2}76767676767${c1}////${c2}76767${c1}/////////
            ///////////${c2}76767676${c1}//////${c2}7676${c1}//////////
            ////////////,${c2}7676${c1},///////${c2}767${c1}///////////
            /////////////*${c2}7676${c1}///////${c2}76${c1}////////////
            ///////////////${c2}7676${c1}////////////////////
             ///////////////${c2}7676${c1}///${c2}767${c1}////////////
              //////////////////////${c2}'${c1}////////////
               //////${c2}.7676767676767676767,${c1}//////
                /////${c2}767676767676767676767${c1}/////
                  ///////////////////////////
                     /////////////////////
                         /////////////
            """, new Attribute[][]{new Attribute[]{CYAN_TEXT(), WHITE_TEXT()}}),

    RASPBIAN("""
            ${c1}  `.::///+:/-.        --///+//-:``
             `+oooooooooooo:   `+oooooooooooo:
              /oooo++//ooooo:  ooooo+//+ooooo.
              `+ooooooo:-:oo-  +o+::/ooooooo:
               `:oooooooo+``    `.oooooooo+-
                 `:++ooo/.        :+ooo+/.`
                    ${c2}...`  `.----.` ``..
                 .::::-``:::::::::.`-:::-`
                -:::-`   .:::::::-`  `-:::-
               `::.  `.--.`  `` `.---.``.::`
                   .::::::::`  -::::::::` `
             .::` .:::::::::- `::::::::::``::.
            -:::` ::::::::::.  ::::::::::.`:::-
            ::::  -::::::::.   `-::::::::  ::::
            -::-   .-:::-.``....``.-::-.   -::-
             .. ``       .::::::::.     `..`..
               -:::-`   -::::::::::`  .:::::`
               :::::::` -::::::::::` :::::::.
               .:::::::  -::::::::. ::::::::
                `-:::::`   ..--.`   ::::::.
                  `...`  `...--..`  `...`
                        .::::::::::
                         `.-::::-`
            """, new Attribute[][]{new Attribute[]{GREEN_TEXT(), RED_TEXT()}}),

    RASPBIAN_SMALL("""
            ${c1}   ..    ,.
              :oo: .:oo:
              'o\\o o/o:
            ${c2} :: . :: . ::
            :: :::  ::: ::
            :'  '',.''  ':
             ::: :::: :::
             ':,  ''  ,:'
               ' ~::~ '
            """, new Attribute[][]{new Attribute[]{GREEN_TEXT(), RED_TEXT()}}),


    REDHAT("""
            ${c1}           .MMM..:MMMMMMM
                      MMMMMMMMMMMMMMMMMM
                      MMMMMMMMMMMMMMMMMMMM.
                     MMMMMMMMMMMMMMMMMMMMMM
                    ,MMMMMMMMMMMMMMMMMMMMMM:
                    MMMMMMMMMMMMMMMMMMMMMMMM
              .MMMM'  MMMMMMMMMMMMMMMMMMMMMM
             MMMMMM    `MMMMMMMMMMMMMMMMMMMM.
            MMMMMMMM      MMMMMMMMMMMMMMMMMM .
            MMMMMMMMM.       `MMMMMMMMMMMMM' MM.
            MMMMMMMMMMM.                     MMMM
            `MMMMMMMMMMMMM.                 ,MMMMM.
             `MMMMMMMMMMMMMMMMM.          ,MMMMMMMM.
                MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
                  MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM:
                     MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
                        `MMMMMMMMMMMMMMMMMMMMMMMM:
                            ``MMMMMMMMMMMMMMMMM
            """, new Attribute[][]{
            new Attribute[]{RED_TEXT()}
    }),

    REDHAT_OLD("""
            ${c1}             `.-..........`
                        `////////::.`-/.
                        -: ....-////////.
                        //:-::///////////`
                 `--::: `-://////////////:
                 //////-    ``.-:///////// .`
                 `://////:-.`    :///////::///:`
                   .-/////////:---/////////////:
                      .-://////////////////////.
            ${c2}         yMN+`.-${c1}::///////////////-`
            ${c2}      .-`:NMMNMs`  `..-------..`
                   MN+/mMMMMMhoooyysshsss
            MMM    MMMMMMMMMMMMMMyyddMMM+
             MMMM   MMMMMMMMMMMMMNdyNMMh`     hyhMMM
              MMMMMMMMMMMMMMMMyoNNNMMM+.   MMMMMMMM
               MMNMMMNNMMMMMNM+ mhsMNyyyyMNMMMMsMM
            """, new Attribute[][]{
            new Attribute[]{RED_TEXT(), CYAN_TEXT()}
    }),

    STEAMOS("""
            ${c1}              .,,,,.
                    .,'onNMMMMMNNnn',.
                 .'oNMANKMMMMMMMMMMMNNn'.
               .'ANMMMMMMMXKNNWWWPFFWNNMNn.
              ;NNMMMMMMMMMMNWW'' ,.., 'WMMM,
             ;NMMMMV+##+VNWWW' .+;'':+, 'WMW,
            ,VNNWP+${c2}######${c1}+WW,  ${c2}+:    ${c1}:+, +MMM,
            '${c2}+#############,   +.    ,+' ${c1}+NMMM
            ${c2}  '*#########*'     '*,,*' ${c1}.+NMMMM.
            ${c2}     `'*###*'          ,.,;###${c1}+WNM,
            ${c2}         .,;;,      .;##########${c1}+W
            ${c2},',.         ';  ,+##############'
             '###+. :,. .,; ,###############'
              '####.. `'' .,###############'
                '#####+++################'
                  '*##################*'
                     ''*##########*''
                          ''''''
                        """, new Attribute[][]{
            new Attribute[]{WHITE_TEXT(), BLUE_TEXT()}
    }),

    UBUNTU("""
            ${c1}            .-/+oossssoo+\\-.
                    ´:+ssssssssssssssssss+:`
                  -+ssssssssssssssssssyyssss+-
                .ossssssssssssssssss${c2}dMMMNy${c1}sssso.
               /sssssssssss${c2}hdmmNNmmyNMMMMh${c1}ssssss\\
              +sssssssss${c2}hm${c1}yd${c2}MMMMMMMNddddy${c1}ssssssss+
             /ssssssss${c2}hNMMM${c1}yh${c2}hyyyyhmNMMMNh${c1}ssssssss\\
            .ssssssss${c2}dMMMNh${c1}ssssssssss${c2}hNMMMd${c1}ssssssss.
            +ssss${c2}hhhyNMMNy${c1}ssssssssssss${c2}yNMMMy${c1}sssssss+
            oss${c2}yNMMMNyMMh${c1}ssssssssssssss${c2}hmmmh${c1}ssssssso
            oss${c2}yNMMMNyMMh${c1}sssssssssssssshmmmh${c1}ssssssso
            +ssss${c2}hhhyNMMNy${c1}ssssssssssss${c2}yNMMMy${c1}sssssss+
            .ssssssss${c2}dMMMNh${c1}ssssssssss${c2}hNMMMd${c1}ssssssss.
             \\ssssssss${c2}hNMMM${c1}yh${c2}hyyyyhdNMMMNh${c1}ssssssss/
              +sssssssss${c2}dm${c1}yd${c2}MMMMMMMMddddy${c1}ssssssss+
               \\sssssssssss${c2}hdmNNNNmyNMMMMh${c1}ssssss/
                .ossssssssssssssssss${c2}dMMMNy${c1}sssso.
                  -+sssssssssssssssss${c2}yyy${c1}ssss+-
                    `:+ssssssssssssssssss+:`
                        .-\\+oossssoo+/-.
            """, new Attribute[][]{
            new Attribute[]{TEXT_COLOR(233, 84, 32), WHITE_TEXT()}
    }),

    UBUNTU_OLD("""
            ${c1}                         ./+o+-
            ${c2}                 yyyyy- ${c1}-yyyyyy+
            ${c2}              ${c2}://+//////${c1}-yyyyyyo
            ${c3}          .++ ${c2}.:/++++++/-${c1}.+sss/`
            ${c3}        .:++o:  ${c2}/++++++++/:--:/-
            ${c3}       o:+o+:++.${c2}`..```.-/oo+++++/
            ${c3}      .:+o:+o/.${c2}          `+sssoo+/
            ${c2} .++/+:${c3}+oo+o:`${c2}             /sssooo.
            ${c2}/+++//+:${c3}`oo+o${c2}               /::--:.
            ${c2}+/+o+++${c3}`o++o${c1}               ++////.
            ${c2} .++.o+${c3}++oo+:`${c1}             /dddhhh.
            ${c3}      .+.o+oo:.${c1}          `oddhhhh+
            ${c3}       +.++o+o`${c1}`-````.:ohdhhhhh+
            ${c3}        `:o+++ ${c1}`ohhhhhhhhyo++os:
            ${c3}          .o:${c1}`.syhhhhhhh/${c3}.oo++o`
            ${c1}              /osyyyyyyo${c3}++ooo+++/
            ${c1}                  ````` ${c3}+oo+++o:
            ${c3}                         `oo++.
            """, new Attribute[][]{
            new Attribute[]{RED_TEXT(), CYAN_TEXT(), YELLOW_TEXT()}
    }),

    UBUNTU_SMALL("""
            ${c1}         _
                 ---(_)
             _/  ---  \\
            (_) |   |
              \\  --- _/
                 ---(_)
            """, new Attribute[][]{
            new Attribute[]{CYAN_TEXT()}
    }),

    UBUNTU_STUDIO("""
            ${c1}              ..-::::::-.`
                     `.:+++++++++++${c2}ooo${c1}++:.`
                   ./+++++++++++++${c2}sMMMNdyo${c1}+/.
                 .++++++++++++++++${c2}oyhmMMMMms${c1}++.
               `/+++++++++${c2}osyhddddhys${c1}+${c2}osdMMMh${c1}++/`
              `+++++++++${c2}ydMMMMNNNMMMMNds${c1}+${c2}oyyo${c1}++++`
              +++++++++${c2}dMMNhso${c1}++++${c2}oydNMMmo${c1}++++++++`
             :+${c2}odmy${c1}+++${c2}ooysoohmNMMNmyoohMMNs${c1}+++++++:
             ++${c2}dMMm${c1}+${c2}oNMd${c1}++${c2}yMMMmhhmMMNs+yMMNo${c1}+++++++
            `++${c2}NMMy${c1}+${c2}hMMd${c1}+${c2}oMMMs${c1}++++${c2}sMMN${c1}++${c2}NMMs${c1}+++++++.
            `++${c2}NMMy${c1}+${c2}hMMd${c1}+${c2}oMMMo${c1}++++${c2}sMMN${c1}++${c2}mMMs${c1}+++++++.
             ++${c2}dMMd${c1}+${c2}oNMm${c1}++${c2}yMMNdhhdMMMs${c1}+y${c2}MMNo${c1}+++++++
             :+${c2}odmy${c1}++${c2}oo${c1}+${c2}ss${c1}+${c2}ohNMMMMmho${c1}+${c2}yMMMs${c1}+++++++:
              +++++++++${c2}hMMmhs+ooo+oshNMMms${c1}++++++++
              `++++++++${c2}oymMMMMNmmNMMMMmy+oys${c1}+++++`
               `/+++++++++${c2}oyhdmmmmdhso+sdMMMs${c1}++/
                 ./+++++++++++++++${c2}oyhdNMMMms${c1}++.
                   ./+++++++++++++${c2}hMMMNdyo${c1}+/.
                     `.:+++++++++++${c2}sso${c1}++:.
                          ..-::::::-..
            """, new Attribute[][]{
            new Attribute[]{CYAN_TEXT(), WHITE_TEXT()}
    }),

    UBUNTU_GNOME("""
            ${c1}          ./o.
                    .oooooooo
                  .oooo```soooo
                .oooo`     `soooo
               .ooo`   ${c2}.o.${c1}   `\\/ooo.
               :ooo   ${c2}:oooo.${c1}   `\\/ooo.
                sooo    ${c2}`ooooo${c1}    \\/oooo
                 \\/ooo    ${c2}`soooo${c1}    `ooooo
                  `soooo    ${c2}`\\/ooo${c1}    `soooo
            ${c2}./oo    ${c1}`\\/ooo    ${c2}`/oooo.${c1}   `/ooo
            ${c2}`\\/ooo.   ${c1}`/oooo.   ${c2}`/oooo.${c1}   ``
            ${c2}  `\\/ooo.    ${c1}/oooo     ${c2}/ooo`
            ${c2}     `ooooo    ${c1}``    ${c2}.oooo
            ${c2}       `soooo.     .oooo`
                     `\\/oooooooooo`
                        ``\\/oo``
            """, new Attribute[][]{
            new Attribute[]{WHITE_TEXT(), CYAN_TEXT()}
    }),

    WINDOWS("""
            ${c1}        ,.=:!!t3Z3z.,
                   :tt:::tt333EE3
            ${c1}       Et:::ztt33EEEL${c2} @Ee.,      ..,
            ${c1}      ;tt:::tt333EE7${c2} ;EEEEEEttttt33#
            ${c1}     :Et:::zt333EEQ.${c2} $EEEEEttttt33QL
            ${c1}     it::::tt333EEF${c2} @EEEEEEttttt33F
            ${c1}    ;3=*^```"*4EEV${c2} :EEEEEEttttt33@.
            ${c3}    ,.=::::!t=., ${c1}`${c2} @EEEEEEtttz33QF
            ${c3}   ;::::::::zt33)${c2}   "4EEEtttji3P*
            ${c3}  :t::::::::tt33.${c4}:Z3z..${c2}  ``${c4} ,..g.
            ${c3}  i::::::::zt33F${c4} AEEEtttt::::ztF
            ${c3} ;:::::::::t33V${c4} ;EEEttttt::::t3
            ${c3} E::::::::zt33L${c4} @EEEtttt::::z3F
            ${c3}{3=*^```"*4E3)${c4} ;EEEtttt:::::tZ`
            ${c3}             `${c4} :EEEEtttt::::z7
                             "VEzjt:;;z>*`
            """, new Attribute[][]{
            new Attribute[]{RED_TEXT(), GREEN_TEXT(), BLUE_TEXT(), YELLOW_TEXT()}
    }),

    WINDOWS_10("""
            ${c1}                                ..,
                                ....,,:;+ccllll
                  ...,,+:;  cllllllllllllllllll
            ,cclllllllllll  lllllllllllllllllll
            llllllllllllll  lllllllllllllllllll
            llllllllllllll  lllllllllllllllllll
            llllllllllllll  lllllllllllllllllll
            llllllllllllll  lllllllllllllllllll
            llllllllllllll  lllllllllllllllllll

            llllllllllllll  lllllllllllllllllll
            llllllllllllll  lllllllllllllllllll
            llllllllllllll  lllllllllllllllllll
            llllllllllllll  lllllllllllllllllll
            llllllllllllll  lllllllllllllllllll
            `'ccllllllllll  lllllllllllllllllll
                   ``'"*::  :ccllllllllllllllll
                                   ````''*::cll
                                             ``
            """, new Attribute[][]{
            new Attribute[]{CYAN_TEXT()}
    }),

    WINDOWS_11("""
            ${c1}
            ################  ################
            ################  ################
            ################  ################
            ################  ################
            ################  ################
            ################  ################
            ################  ################

            ################  ################
            ################  ################
            ################  ################
            ################  ################
            ################  ################
            ################  ################
            ################  ################
            """, new Attribute[][]{
            new Attribute[]{CYAN_TEXT()}
    });
    final String distroArt;
    final Pattern interpolator = Pattern.compile("(\\$\\{c\\d+})");
    final Pattern easyLineSep = Pattern.compile("\r\n?|\n");

    Attribute[][] palette;

    AsciiEnum(String distroArt, Attribute[][] palette) {
        this.distroArt = distroArt;
        setPalette(palette);
        validatePaletteSelection(0);
    }

    public int getColorCount() {
        Matcher matcher = interpolator.matcher(distroArt);
        List<Integer> colorPositions = new ArrayList<>();
        while (matcher.find()) {
            colorPositions.add(Integer.parseInt(matcher.group(1).replaceAll("\\D", "")));
        }
        Optional<Integer> maxValue = colorPositions.stream().max((spam, eggs) -> spam.compareTo(eggs));
        if (maxValue.isEmpty()) {
            return 0;
        }
        return maxValue.get();
    }

    public void setPalette(Attribute[][] palette) {
        Matcher matcher = interpolator.matcher(distroArt);
        if (palette[0].length < getColorCount()) {
            throw new CommandLine.PicocliException(
                    String.format("provided color palette doesn't have enough colors\n(needs %d but found %d)\n%s",
                            getColorCount(),
                            palette[0].length,
                            this.distroArt));
        }
        this.palette = palette;
    }

    int validatePaletteSelection(int selection) {
        if (null == palette) {
            throw new CommandLine.PicocliException("color palette selection can not be assigned with null-valued palette");
        } else if (palette[0].length <= selection) {
            throw new CommandLine.PicocliException(
                    String.format("color palette selection \"%d\" invalid for palette of length %d in the following image:\n%s",
                            selection,
                            palette[0].length,
                            this.distroArt));
        }
        return selection;
    }

    /**
     * formats a given string per {@link #palette}.
     *
     * @param text String which may have none, one or many formatting placeholders {@code ie ${c1}}.
     * @return String rendered per format placeholder numbers and color palette.
     */
    public String render(String text, int paletteSelection) {
        Matcher matcher = interpolator.matcher(text);
        if (!matcher.find()) {
            return colorizeWithBreaklines(text, paletteSelection);
        }

        String firstHalf = text.substring(0, matcher.start(1));
        String secondHalf = render(text.substring(matcher.end(1)), getPaletteSelectionFromInterpolator(matcher.group(1)));
        if (firstHalf.substring(firstHalf.length() - 1).matches(".*" + easyLineSep.pattern())) {
            return colorizeWithBreaklines(firstHalf, paletteSelection) + System.lineSeparator() + secondHalf;
        }
        return colorizeWithBreaklines(firstHalf, paletteSelection) + secondHalf;
    }

    int getPaletteSelectionFromInterpolator(String text) {
        return validatePaletteSelection(Integer.parseInt(text.replaceAll("\\D", "")) - 1);
    }

    /**
     * wrapper for <a href="https://dialex.github.io/JColor/com/diogonunes/jcolor/Ansi.html#colorize(com.diogonunes.jcolor.Command)">jcolor.ansi#colorize</a>,
     * allowing for multiline strings to maintain color between lines.
     */
    public String colorizeWithBreaklines(String text, int paletteSelection) {
        return Arrays.stream(text.split(easyLineSep.pattern()))
                .map(segment -> colorize(segment, palette[0][paletteSelection]))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String toString() {
        Matcher matcher = interpolator.matcher(distroArt);
        if (matcher.find()) {
            return render(
                    distroArt.substring(matcher.end(1)),
                    getPaletteSelectionFromInterpolator(matcher.group(1))
            );
        }
        // no interpolator, thus no color assignment, default to first entry in palette.
        return render(distroArt, validatePaletteSelection(0));
    }
}
