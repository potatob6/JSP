package io.github.potatob6.Models;

import io.github.potatob6.Annos.PrimaryKey;
import io.github.potatob6.Annos.SQLSeq;
import io.github.potatob6.Annos.TableName;

@TableName(name = "GenerateBorrow")
public class GenerateBorrowBean {
    @PrimaryKey
    @SQLSeq(order = 1)
    public int nextBorrowId;
}
