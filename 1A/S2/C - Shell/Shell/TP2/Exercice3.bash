#!/usr/bin/env bash

echo -e "$(find . -name "*~" -print -o -name "*.core" -print -o -name "#*#" -print)\n"