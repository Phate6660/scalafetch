## scalafetch

Learning Scala, by implementing a neofetch alternative.

Currently supported: distro and kernel.

## help

`sbt:scalafetch> run -H`

```
-d  display the distro
-e  display $EDITOR
-H  display this help
-h  display hostname
-k  display the kernel
-m  display currently playing music in mpd
-s  display the shell
-U  display the user
-u  display uptime
```

## Current output (from my machine)

`sbt:scalafetch> run -d true -e true -h true -k true -s true -U true -u true`

```
Distro:    Gentoo
Editor:    /usr/bin/emacsclient
Hostname:  gentoo
Kernel:    5.4.48-ck-valley
Shell:     /bin/bash
Uptime:    1d 7h 29m
User:      valley
Music:     Mr. Bungle - Mr. Bungle - Quote Unquote
```
