import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShipLoadingTest {

    protected ShipLoading solution;

    @Before
    public void setUp() {
        solution = new ShipLoading();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] cranes = new int[]{6, 8, 9};
        String[] boxes = new String[]{"2 5 2 4 7"};

        int expected = 2;
        int actual = solution.minimumTime(cranes, boxes);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] cranes = new int[]{19, 20};
        String[] boxes = new String[]{"14 12 16 19 16 1 5"};

        int expected = 4;
        int actual = solution.minimumTime(cranes, boxes);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] cranes = new int[]{23, 32, 25, 28};
        String[] boxes = new String[]{"5 27 10 16 24 20 2 32 18 7"};

        int expected = 3;
        int actual = solution.minimumTime(cranes, boxes);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] cranes = new int[]{11, 17, 5, 2, 20, 7, 5, 5, 20, 7};
        String[] boxes = new String[]{"18 18 15 15 17"};

        int expected = 2;
        int actual = solution.minimumTime(cranes, boxes);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] cranes = new int[]{56, 114, 979, 120, 120, 87, 480};
        String[] boxes = new String[]{"221 882 504 358 642 674 212 679 203 279 632 799 79", "6 502 275 823 372 594 482 343"};

        int expected = 12;
        int actual = solution.minimumTime(cranes, boxes);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void sysTestCase17() {
        int[] cranes = new int[]{741, 502, 70, 39, 96, 102, 12, 93, 469, 92, 1, 133, 75, 21, 23, 795, 50, 80, 129, 16, 33, 118, 84, 131, 320, 56, 124, 73, 77, 48, 45, 69, 101, 79, 10, 72, 78, 59};
        String[] boxes = new String[]{"786 665 175 656 769 373 742 552 480 423 493 408 69", "4 163 620 176 667 332 627 147 726 438 685 507 138 ", "763 671 364 455 507 343 391 422 688 585 288 676 73", "9 570 268 329 721 649 554 232 591 464 138 741 358 ", "743 665 248 284 295 545 784 754 330 710 180 324 62", "4 363 445 756 614 484 631 371 607 494 670 535 451 ", "753 539 561 742 415 387 791 786 367 490 227 464 44", "5 614 239 586 309 379 258 786 469 774 183 148 601 ", "366 139 648 526 197 409 524 226 441 172 736 303 13", "4 588 511 282 188 740 664 302 520 680 661 140 420 ", "140 787 526 190 571 482 153 524 134 498 521 473 52", "4 235 227 513 374 444 166 272 396 519 161 721 561 ", "479 207 142 519 638 218 733 617 707 724 662 138 14", "7 682 619 166 768 795 792 383 444 325 136 451 627 ", "455 211 186 220 223 778 587 730 693 727 259 554 42", "1 688"};

        int expected = 46;
        int actual = solution.minimumTime(cranes, boxes);

        Assert.assertEquals(expected, actual);
    }
}
