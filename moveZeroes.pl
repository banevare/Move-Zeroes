use Data::Dump qw(dump);
use Test::More qw(no_plan);

sub swap($$$){
        my ($i,$j,$nums) = @_;
        my $temp = $$nums[$i];
        $$nums[$i]  = $$nums[$j];
        $$nums[$j]  = $temp;
}
sub moveZeroes(@) {
        my (@nums) = @_;
        return unless @nums;
        my $j = 0;
        for(; $j < @nums; $j++){
            last if $nums[$j];
        }
        return if $j == @nums;                                                
        for(my $i = 0; $i < @nums; $i++){
            if($nums[$i] == 0){
                # say STDERR "i = $i , j = $j";
                for(; $j < @nums; $j++){
                    if($nums[$j] != 0 && $j > $i){
                       swap($i,$j,\@nums);
                       last;
                   }
                }
            }
        }
        return [@nums];
    }
        is_deeply moveZeroes(1,1,0),[1,1,0];
        is_deeply moveZeroes(qw(0)), [qw(0)];
        is_deeply moveZeroes(qw(1 0)), [qw(1 0)];
        is_deeply moveZeroes(qw(1 1 0)), [qw(1 1 0)];
        is_deeply moveZeroes(qw(0 0 4 3)), [qw(4 3 0 0")];
        is_deeply moveZeroes(qw(0 1 0 3 12)), [qw(1 3 12 0 0)];
        is_deeply moveZeroes(qw(1 0 5 0 0 6 0 0 0 3 4)), [qw(1 5 6 3 4 0 0 0 0 0 0")];
        is_deeply moveZeroes(qw(0 4 0 0 6 3 0 1 0 0 0 9)), [qw(4 6 3 1 9 0 0 0 0 0 0 0)];
