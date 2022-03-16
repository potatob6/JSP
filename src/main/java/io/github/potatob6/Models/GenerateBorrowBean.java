package io.github.potatob6.Models;

import io.github.potatob6.Annos.PrimaryKey;
import io.github.potatob6.Annos.SQLSeq;

public class GenerateBorrowBean {
    @PrimaryKey
    @SQLSeq(order = 1)
    public int nextBorrowId;
}
