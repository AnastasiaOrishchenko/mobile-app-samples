import {useNavigation} from '@react-navigation/native';
import React from 'react';
import {Dimensions, FlatList} from 'react-native';
import PhotoGridItem from './PhotoGridItem';

function PhotoGrid({photos, numColumns, onEndReached}) {
  const {width} = Dimensions.get('window');
  const size = width / numColumns;
  const navigation = useNavigation();

  return (
    <FlatList
      data={photos}
      keyExtractor={item => item.id}
      numColumns={numColumns}
      onEndReached={onEndReached}
      renderItem={({item}) => (
        <PhotoGridItem
          photo={item}
          size={size}
          onClick={() => navigation.push('DetailsScreen', {photo: item})}
        />
      )}
    />
  );
}

export default PhotoGrid;
